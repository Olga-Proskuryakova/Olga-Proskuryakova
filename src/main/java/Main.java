import db.MySQLConnector;
import object.Curator;
import object.Group;
import object.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentsTable;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {

            StudentsTable studentsTable = new StudentsTable();
            ArrayList<Student> students = studentsTable.selectAll();
            if (students.isEmpty()) {
                studentsTable.insert(new Student("Некрасов Роман Даниилович", "муж", 1));
                studentsTable.insert(new Student("Тихомирова Варвара Григорьевна", "жен", 2));
                studentsTable.insert(new Student("Кожевникова Надежда Ивановна", "жен", 3));
                studentsTable.insert(new Student("Любимов Руслан Григорьевич", "муж", 1));
                studentsTable.insert(new Student("Некрасова Александра Андреевна", "жен", 2));
                studentsTable.insert(new Student("Алексеев Богдан Львович", "муж", 3));
                studentsTable.insert(new Student("Лебедева Александра Романовна", "жен", 1));
                studentsTable.insert(new Student("Осипов Леонид Степанович", "муж", 2));
                studentsTable.insert(new Student("Герасимова Таисия Никитична", "жен", 3));
                studentsTable.insert(new Student("Попов Тимур Кириллович", "муж", 1));
                studentsTable.insert(new Student("Федорова Екатерина Леонидовна", "жен", 2));
                studentsTable.insert(new Student("Гуляев Владимир Мартинович", "муж", 3));
                studentsTable.insert(new Student("Крылова Кристина Львовна", "жен", 1));
                studentsTable.insert(new Student("Филиппов Марк Дмитриевич", "муж", 2));
                studentsTable.insert(new Student("Фролов Марк Андреевич", "муж", 3));

            }

            GroupTable groupTable = new GroupTable();
            ArrayList<Group> groups = groupTable.selectAll();
            if (groups.isEmpty()) {
                groupTable.insert(new Group("Middle",1 ));
                groupTable.insert(new Group("Senior",2 ));
                groupTable.insert(new Group("Lead",3 ));
                groups = groupTable.selectAll();

            }

            CuratorTable curatorTable = new CuratorTable();
            ArrayList<Curator> curators = curatorTable.selectAll();
            if (curators.isEmpty()) {
                curatorTable.insert(new Curator("Денисов Дмитрий Артёмович"));
                curatorTable.insert(new Curator("Рожков Михаил Степанович"));
                curatorTable.insert(new Curator("Трофимов Александр Дмитриевич"));
                curatorTable.insert(new Curator("Бобров Василий Степанович"));
            }
            studentsTable.selectAllWomen();
            System.out.println("-------------------------------------------------");

            studentsTable.selectCount();

            System.out.println("-------------------------------------------------");
            studentsTable.selectAllStudentsFromGroup();

            System.out.println("-------------------------------------------------");
            studentsTable.selectAllStudentWitchGroupAndCurator();

            System.out.println("-------------------------------------------------");
            groupTable.selectAllGroupAndCurator();

            groups.get(2).setId_curator(10);
            groupTable.update(groups.get(2));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MySQLConnector.close();
        }
    }
}
