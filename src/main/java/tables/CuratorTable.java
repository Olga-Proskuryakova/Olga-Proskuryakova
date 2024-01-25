package tables;

import db.MySQLConnector;
import object.Curator;
import object.Group;
import object.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CuratorTable extends AbsTable {
    private final static String TABLE_NAME = "Curator";

    public CuratorTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("id", "INT PRIMARY KEY AUTO_INCREMENT");
        columns.put("fio", "varchar(100)");
        create();
    }
    public void insert(Curator curator){
        db = new MySQLConnector();
        final String sqlRequest = String.format("insert into %s (fio) VALUES ('%s');",
                tableName, curator.getFio());
        db.executeRequest(sqlRequest);
    }
    private ArrayList<Curator> resultSetToArray(ResultSet rs){
        ArrayList<Curator> result = new ArrayList<>();
        try {
            while (rs.next()) {
                result.add(
                        new Curator(
                                rs.getInt("id"),
                                rs.getString("fio")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public ArrayList<Curator> selectAll(){
        db = new MySQLConnector();
        final String sqlRequest = String.format("SELECT * FROM %s", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        return resultSetToArray(rs);
    }
}