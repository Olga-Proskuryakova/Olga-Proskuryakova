package db;

import settings.ISettings;
import settings.PropertiesReader;

import java.sql.*;
import java.util.Map;

public class MySQLConnector implements IDBConnector {
    public static Connection connection = null;
    public static Statement statement = null;

    public MySQLConnector() {
        connect();
    }

    private void connect() {
        ISettings reader = new PropertiesReader();
        Map<String, String> settings = reader.read();
        if (connection == null) {
            try {
                connection = DriverManager
                        .getConnection(settings.get("url") + "/" + settings.get("db_name"),
                                settings.get("db_username"),
                                settings.get("db_password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeRequest(String response) {
        try {
            statement.execute(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeRequestWithAnswer(String response) {
        try {
            return statement.executeQuery(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
