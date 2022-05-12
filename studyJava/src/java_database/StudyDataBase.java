package java_database;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.*;

public class StudyDataBase {

    public static void main(String[] args) throws ClassNotFoundException, SAXException, XMLStreamException, TransformerException, ParserConfigurationException {
        String username = "alex";
        String password = "1234567";
        String url = "jdbc:mysql://localhost:3306/motor_db";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement()) {
            statement.executeUpdate("DROP TABLE Books");
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
        } catch (SQLException e) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }



}
