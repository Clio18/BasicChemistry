import java.sql.*;

public class ConnectionDATA {

    public Connection getConnection() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

}

