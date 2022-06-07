package com.visual.casalinda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovementSQL {
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;
    ArrayList<Movement> lista = new ArrayList<>();

    public void registration(Movement movement){
        String insert = "INSERT INTO movement (name,code,quantity,type,value_unity, value_total, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connection = DatabaseConnection.getConnection();

        float total = movement.getValue() * (float) movement.getQuantity();
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, movement.getProduct().getName());
            statement.setString(2, movement.getProduct().getCode());
            statement.setInt(3, movement.getQuantity());
            statement.setString(4, movement.getType());
            statement.setFloat(5, movement.getValue());
            statement.setFloat(6, total);
            statement.setDate(7, movement.getDate());
            statement.execute();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Movement> SearchProduct(){
        String select = "SELECT * FROM movement";
        connection = DatabaseConnection.getConnection();
        try{
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                Movement movement = new Movement();
                product.setName(resultSet.getString("name"));
                product.setCode(resultSet.getString("code"));
                movement.setProduct(product);
                System.out.println(product);
                movement.setQuantity(resultSet.getInt("quantity"));
                movement.setType(resultSet.getString("type"));
                movement.setValue(resultSet.getFloat("value_unity"));
                movement.setDate(resultSet.getDate("date"));
                lista.add(movement);
                System.out.println(lista);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public void valueDay(){

    }

}
