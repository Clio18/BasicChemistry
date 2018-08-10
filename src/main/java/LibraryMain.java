import java.sql.*;
import java.util.ArrayList;

public class LibraryMain {

    public Connection getConnection() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
           // System.out.println("Connection is ok");
        } catch (SQLException e){
            e.printStackTrace();
            //System.out.println("Connection ERROR");
        }
        return c;
    }

}

