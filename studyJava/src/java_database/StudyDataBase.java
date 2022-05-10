package java_database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudyDataBase {



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jbc.Driver");
        Connection connect = DriverManager.getConnection("jbc::mysql://localhost/countries?"
                +"user=root&password=root");
        selectAll(connect);
    }

    private static void selectAll(java.sql.Connection conn) throws SQLException{
        Statement statement = conn.createStatement();

    }


}
