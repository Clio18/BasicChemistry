import java.sql.SQLException;

public interface Service {
    double getMolecularMass(String s) throws SQLException;
}
