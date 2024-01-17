package tables;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbsTable {
protected String tableName;
protected Connection connection;
protected Statement statement;

public AbsTable(String tableName) throws SQLException {
       this.tableName = tableName;
       this.connection = connection;
       statement = connection.createStatement();
    }
    public abstract void create() throws SQLException;
    public abstract void createTable();

    public abstract void fillTable();

    public void printAllRecords() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + ": " + resultSet.getObject(i) + "  ");
            }
            System.out.println();
        }
    }
}