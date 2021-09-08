package com.goldencodes.zbattle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private Connection _connection;

    private String _host;
    private String _database;
    private String _password;
    private String _username;
    private int _port;

    public MySQL(String database, String host, int port, String username, String password) {
        _database = database;
        _host = host;
        _port = port;
        _username = username;
        _password = password;
    }

    public Connection openConnection() throws SQLException {

        if (_connection != null && !_connection.isClosed())
            return _connection;

        return _connection = DriverManager.getConnection("jdbc:mysql://");
    }
}
