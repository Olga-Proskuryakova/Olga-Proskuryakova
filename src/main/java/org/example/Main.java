package org.example;
import java.sql.*;

import static db.MySQLConnector.connection;
import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Подключение к базе данных
        String url = "jdbc:mysql://localhost:3306/test1";
        String username = "root";
        String password = "140603@_Pov";

        try {
            // Устанавливаем соединение с базой данных
            Connection connection = getConnection("jdbc:mysql://localhost:3306/test1", "root", "140603@_Pov");

            // Создаем таблицу Student
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Student (id INT PRIMARY KEY, fio VARCHAR(50), " +
                    "sex VARCHAR(10), id_group INT)");

            // Создаем таблицу Group
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Group_table (id INT PRIMARY KEY, " +
                    "name VARCHAR(50), id_curator INT)");

            // Создаем таблицу Curator
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Curator (id INT PRIMARY KEY, fio VARCHAR(50))");

            // Заполняем таблицы данными
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (1, 'Иванов Иван', 'М', 1)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (2, 'Петров Петр', 'М', 1)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (3, 'Сидорова Ирина', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (4, 'Смирнова Ольга', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (5, 'Козлов Дмитрий', 'М', 1)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (6, 'Синьков Антон', 'М', 1)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (7, 'Лепилова Марина', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (8, 'Злобнина Алина', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (10, 'Конев Сергей', 'М', 1)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (11, 'Дебрин Владимир', 'М', 1)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (12, 'Сучкова Алла', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (13, 'Борзикова Полина', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (14, 'Демидова Лена', 'Ж', 2)");
            statement.executeUpdate("INSERT INTO Student (id, fio, sex, id_group) VALUES (15, 'Полякова Мария', 'Ж', 2)");
            // ...

            statement.executeUpdate("INSERT INTO Group_table (id, name, id_curator) VALUES (1, 'Группа 1', 1)");
            statement.executeUpdate("INSERT INTO Group_table (id, name, id_curator) VALUES (2, 'Группа 2', 2)");
            statement.executeUpdate("INSERT INTO Group_table (id, name, id_curator) VALUES (3, 'Группа 3', 3)");
            // ...

            statement.executeUpdate("INSERT INTO Curator (id, fio) VALUES (1, 'Козлова Ирина')");
            statement.executeUpdate("INSERT INTO Curator (id, fio) VALUES (2, 'Лозырева Анна')");
            statement.executeUpdate("INSERT INTO Curator (id, fio) VALUES (3, 'Маликов Иван')");
            statement.executeUpdate("INSERT INTO Curator (id, fio) VALUES (4, 'Гончаров Евгений')");
            // ...

            // Выводим информацию о всех студентах включая название группы и имя куратора
            ResultSet result = statement.executeQuery("SELECT Student.fio, Group_table.name, Curator.fio FROM Student " +
                    "INNER JOIN Group_table ON Student.id_group = Group_table.id INNER JOIN Curator ON Group_table.id_curator = Curator.id");
            while (result.next()) {
                String studentFIO = result.getString(1);
                String groupName = result.getString(2);
                String curatorName = result.getString(3);
                System.out.println(studentFIO + " - " + groupName + ", куратор: " + curatorName);
            }

            // Выводим количество студентов
            ResultSet countResult = statement.executeQuery("SELECT COUNT(*) FROM Student");
            if (countResult.next()) {
                int count = countResult.getInt(1);
                System.out.println("Количество студентов: " + count);
            }

            // Выводим студенток
            ResultSet femaleStudents = statement.executeQuery("SELECT * FROM Student WHERE sex = 'Ж'");
            while (femaleStudents.next()) {
                String studentFIO = femaleStudents.getString("fio");
                System.out.println(studentFIO);
            }

            // Обновляем данные по группе, сменив куратора
            statement.executeUpdate("UPDATE Group_table SET id_curator = 3 WHERE id = 1");

            // Выводим список групп с их кураторами
            ResultSet groupResult = statement.executeQuery("SELECT Group_table.name, " +
                    "Curator.fio FROM Group_table INNER JOIN Curator ON Group_table.id_curator = Curator.id");
            while (groupResult.next()) {
                String groupName = groupResult.getString(1);
                String curatorName = groupResult.getString(2);
                System.out.println(groupName + ": " + curatorName);
            }
            // Выполняем вложенный запрос и выводим студентов из определенной группы
            String groupNameToSearch = "Группа 1";
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Student.fio FROM Student INNER JOIN " +
                    "Group_table ON Student.id_group = Group_table.id WHERE Group_table.name = ?");
            preparedStatement.setString(1, groupNameToSearch);
            ResultSet specificGroupResult = preparedStatement.executeQuery();
            while (specificGroupResult.next()) {
                String studentFIO = specificGroupResult.getString(1);
                System.out.println(studentFIO);
            }

            // Закрываем соединение с базой данных
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


