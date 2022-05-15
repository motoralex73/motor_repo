package java_database;

import org.xml.sax.SAXException;

import javax.net.ssl.SSLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.*;

public class StudyDataBase {

    public static void createTableBooks() throws ClassNotFoundException, ParserConfigurationException, IOException, SSLException, SQLException, SAXException {
        String username = "alex";
        String password = "1234567";
        String url = "jdbc:mysql://localhost:3306/motor_db";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement()) {
            statement.execute("DROP TABLE Books");
            statement.executeUpdate("CREATE TABLE Books (id int, name CHAR(30));");
            statement.executeUpdate("INSERT INTO Books VALUES('1','Inferno');");
            statement.executeUpdate("INSERT INTO Books VALUES ('2','Solomon key');");
            System.out.println("We're create table");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1)+" : ");
                System.out.println(resultSet.getString(2));
                System.out.println("-----------------------------");
            }
        }
    }

    public static void studyInjection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/motor_db";
        String username = "alex";
        String password = "1234567";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement()) {
            statement.execute("DROP TABLE Users");
            statement.executeUpdate("CREATE TABLE Users (id int, name CHAR(30), password CHAR(20));");
            statement.executeUpdate("INSERT INTO Users (id,name,password) VALUES(1,'alex','1234567');");
            statement.executeUpdate("INSERT INTO Users SET id = 2, name = 'otherGuy', password = '123' ;");

            String userId = "2"; //выбираем какого юзера нам выводить по id
            ResultSet resultSet = statement.executeQuery("select * from Users where id = '"+ userId +"'");
            while (resultSet.next()) {
                System.out.println("id user: "+resultSet.getInt("id"));
                System.out.println("userName: "+resultSet.getString("name"));
                System.out.println("userPassword: "+resultSet.getString("password"));
            }
        }
    }

    public static void ab() {
        int a = 111;
        int b = 222;
        System.out.println("after a = "+a+" b = "+b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("before a = "+a+" b = "+b);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, SAXException, ParserConfigurationException {
        //createTableBooks();
        //studyInjection();
        ab();
    }



}
