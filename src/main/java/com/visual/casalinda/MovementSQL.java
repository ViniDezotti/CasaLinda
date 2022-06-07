package com.visual.casalinda;

import javax.xml.datatype.DatatypeConfigurationException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MovementSQL {
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;
    ArrayList<Movement> lista = new ArrayList<>();

    public void registration(Movement movement) {
        String insert = "INSERT INTO movement (name,code,quantity,type,value_unity, value_total, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connection = DatabaseConnection.getConnection();

        float total = movement.getValue() * (float) movement.getQuantity();
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, movement.getName());
            statement.setString(2, movement.getCode());
            statement.setInt(3, movement.getQuantity());
            statement.setString(4, movement.getType());
            statement.setFloat(5, movement.getValue());
            statement.setFloat(6, total);
            statement.setDate(7, movement.getDate());
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movement> SearchProduct() {
        String select = "SELECT * FROM movement";
        connection = DatabaseConnection.getConnection();
        try {
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Movement movement = new Movement();
                movement.setName(resultSet.getString("name"));
                movement.setCode(resultSet.getString("code"));
                movement.setQuantity(resultSet.getInt("quantity"));
                movement.setType(resultSet.getString("type"));
                movement.setValue(resultSet.getFloat("value_unity"));
                movement.setTotal(movement.getValue() * ((float) movement.getQuantity()));
                movement.setDate(resultSet.getDate("date"));
                lista.add(movement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void valueDay() {

    }

    public String transfersDay() {
        String timeToday = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Date data =  java.sql.Date.valueOf(timeToday);
        System.out.println(data);

        String find = "SELECT COUNT (*) FROM movement WHERE date LIKE ?";
        connection = DatabaseConnection.getConnection();

        try {
            System.out.println(resultSet);

            statement = connection.prepareStatement(find);
            statement.setDate(1, data);
            resultSet = statement.executeQuery();
            System.out.println(resultSet.getDate("data").toString());
            resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(resultSet);
    }
}
