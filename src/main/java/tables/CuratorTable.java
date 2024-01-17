package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.Statement;

public class CuratorTable extends AbsTable {
    private final static String TABLE_NAME = "Curator";

    public CuratorTable() throws SQLException {
        super(TABLE_NAME);
    }

    @Override
    public void create() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Curator (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "fio VARCHAR(255))";
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
