
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=Shopping";
        conn= DriverManager.getConnection(url, "sa", "123456");
        return conn;
    }
}
