package com.visual.casalinda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ProductsSQL {
    Connection connection;
    PreparedStatement statement;

    ResultSet resultSet;

    ArrayList<Product> lista = new ArrayList<>();

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

    public void removeProduct(Product product, int lastCode){
        String insert = "DELETE FROM product WHERE code LIKE ?";
        connection = DatabaseConnection.getConnection();

        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, product.getCode());

            statement.execute();
            statement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editProduct(Product product, int lastCode){
        String edit = "UPDATE product SET name = ?, code = ?, quantity = ?, description = ?, category = ? WHERE code = ?";
        connection = DatabaseConnection.getConnection();
        try {
            statement = connection.prepareStatement(edit);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Product> SearchProduct(){
        String select = "SELECT * FROM product";
        connection = DatabaseConnection.getConnection();
        try{
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                product.setCode(resultSet.getString("code"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setDescription(resultSet.getString("description"));
                product.setCategory(resultSet.getString("category"));
                lista.add(product);
                System.out.println(lista);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
