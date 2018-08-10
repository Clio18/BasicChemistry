import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    public static void main(String[] args) throws SQLException {
        Service service = new Service();
        System.out.println(getMolecularMass("C2H5OH", service));
    }

    public static double getMolecularMass(String str, Service service) throws SQLException {
        char[] ss = str.toCharArray();
        ArrayList<String> list = new ArrayList();
        String n = "";
        for (int i = 0; i < ss.length; i++) {
            if (Character.isUpperCase(ss[i])) {
                list.add(String.valueOf(ss[i]));
            } else {
                n = list.get(list.size() - 1) + String.valueOf(ss[i]);
                list.remove(list.size() - 1);
                list.add(n);
            }
        }
        ArrayList<Double> doubleList = new ArrayList<>();
        double massEl = 0;

        for (int i = 0; i < list.size(); i++) {
            massEl = service.getMass(list.get(i).split("\\d")[0]);
            if (list.get(i).split("\\D").length == 0) {
                doubleList.add(massEl);
            } else
                for (String s : list.get(i).split("\\D")) {
                    if (!s.isEmpty()) {
                        doubleList.add(Double.parseDouble(s) * massEl);
                    }
                }
        }
        double totalMass = 0;
        for (int i = 0; i < doubleList.size(); i++) {
            totalMass += doubleList.get(i);
        }
        System.out.println("Molecular mass of " + str + ": ");
        return totalMass;
    }
}
