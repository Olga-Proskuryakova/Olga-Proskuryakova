package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.Statement;

public class GroupTable extends AbsTable{

    private final static String TABLE_NAME = "Group";

    public GroupTable() throws SQLException {
        super(TABLE_NAME);
    }

        @Override
        public void create() throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS Group (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(255), " +
                        "id_curator INT)";
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