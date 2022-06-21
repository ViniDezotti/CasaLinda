package com.visual.casalinda;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

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
            statement.setDate(7, (Date) movement.getDate());
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movement> SearchProduct(String SQL) {
        connection = DatabaseConnection.getConnection();
        try {
            statement = connection.prepareStatement(SQL);
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

    public ArrayList<Movement> SearchDate(Date Data1, Date Data2) {
        lista = new ArrayList<>();
        String SQL = "SELECT * FROM movement WHERE date BETWEEN ? AND ?";
        connection = DatabaseConnection.getConnection();
        try {
            statement = connection.prepareStatement(SQL);
            statement.setDate(1, Data1);
            statement.setDate(2, Data2);
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

    public ArrayList<Movement> searchType(String type, Date Data1, Date Data2) {
        lista = new ArrayList<>();
        String SQL;
        if(Data1 == null) SQL = "SELECT * FROM movement WHERE type = ?";
        else SQL = "SELECT * FROM movement WHERE type = ? AND date BETWEEN ? AND ?";
        connection = DatabaseConnection.getConnection();
        try {
            statement = connection.prepareStatement(SQL);
            if(Data1 == null){
                statement.setString(1, type);
            }
            else {
                statement.setString(1, type);
                statement.setDate(2, Data1);
                statement.setDate(3, Data2);
            }
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

    public double valueDay() {
        LocalDate date = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);

        String find = "SELECT sum(value_total) FROM movement WHERE date = ?";
        connection = DatabaseConnection.getConnection();
        try {
            System.out.println(resultSet);
            statement = connection.prepareStatement(find);
            statement.setDate(1, sqlDate);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getDouble("sum(value_total)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double profitDay() {
        LocalDate date = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);

        String find = "SELECT sum(value_total) FROM movement WHERE date = ? and type = ?";
        connection = DatabaseConnection.getConnection();
        try {
            System.out.println(resultSet);
            statement = connection.prepareStatement(find);
            statement.setDate(1, sqlDate);
            statement.setString(2, "venda");
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getDouble("sum(value_total)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int transfersDay() {
        LocalDate date = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);

        String find = "SELECT count(*) FROM movement WHERE type = ? AND date = ?";
        connection = DatabaseConnection.getConnection();
        try {
            System.out.println(resultSet);
            statement = connection.prepareStatement(find);
            statement.setString(1, "venda");
            statement.setDate(2, sqlDate);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count(*)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
