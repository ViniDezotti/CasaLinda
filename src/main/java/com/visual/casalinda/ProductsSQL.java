package com.visual.casalinda;

import com.visual.casalinda.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductsSQL {
    Connection connection;
    PreparedStatement statement;

    ResultSet resultSet;

    public void insertProduct(Product product){
        String insert = "INSERT INTO product (code,name,quantity,description,category) VALUES (?, ?, ?, ?, ?)";
        connection = DatabaseConnection.getConnection();

        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, product.getCode());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getDescription());
            statement.setString(5, product.getCategory());

            statement.execute();
            statement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet<Product> SearchProdutct(){
        String select = "SELECT * FROM product";

        try{
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setCategory(resultSet.getString("category"));
            }
        }catch (Exception e){

        }
    }
}
