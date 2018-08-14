import java.sql.SQLException;

public class User {
    public static void main(String[] args) throws SQLException {
        Service service = new UserService(new UserDAO());
        System.out.println(service.getMolecularMass("H2O"));
    }

}
