import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Service extends LibraryMain implements getMassDAO {
    public double getMass(String s) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        double mas = 0.0;
        String sql = "select mass from periodic where symbol = " + "'" + s + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            //Retrieve by column name
            mas = rs.getDouble("mass");
            //String name = rs.getString("name");
            //Display values
            //System.out.println("Mass: " + mas);
        }
        rs.close();

        connection.commit();
        return mas;
    }
}
