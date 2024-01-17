package tables;
import db.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTable extends AbsTable {
    private final static String TABLE_NAME = "Student";

    public StudentTable() throws SQLException {
        super(TABLE_NAME);
    }

    @Override
    public void create() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Student (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "fio VARCHAR(255), " +
                    "sex VARCHAR(10), " +
                    "id_group INT)";
            statement.executeUpdate(sql);
        }
    }


    @Override
    public void createTable() {

    }

    @Override
    public void fillTable() {

    }

}