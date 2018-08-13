import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO implements DAO {
    public double getMass(String s) throws SQLException {
        ConnectionDATA libraryMain = new ConnectionDATA();
        Connection connection = libraryMain.getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        double mas = 0.0;
        String sql = "select mass from periodic where symbol = " + "'" + s + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            //Retrieve by column name
            mas = rs.getDouble("mass");
            //Display values
        }
        rs.close();

        connection.commit();
        return mas;
    }
}
