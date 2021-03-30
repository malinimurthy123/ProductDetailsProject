package com.example.ProductDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private Connection connection;

    //this methods attempts the connection to the MySQL database with the provided parameters
    public DBConnection(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(dbURL, user, pwd);
    }

    //getter method for the connection
    public Connection getConnection(){
        return this.connection;
    }

    //closes connection
    public void closeConnection() throws SQLException {
        if (this.connection != null)
            this.connection.close();
    }

}