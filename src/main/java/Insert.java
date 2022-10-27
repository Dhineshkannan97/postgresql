import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test",
                            "postgres", "pg@abi123");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql1 = "INSERT INTO goldcoast (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Dhinesh', 25, 'Ramanathapuram', 20000.00 );";
            stmt.executeUpdate(sql1);


            sql1 = "INSERT INTO goldcoast (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Kaif', 25, 'Madhurai', 15000.00 );";
            stmt.executeUpdate(sql1);

            sql1 = "INSERT INTO goldcoast (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Sivagangai', 20000.00 );";
            stmt.executeUpdate(sql1);

            sql1 = "INSERT INTO goldcoast (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Chennai', 65000.00 );";
            stmt.executeUpdate(sql1);

            ResultSet rs = stmt.executeQuery("SELECT * FROM goldcoast;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
            }
//            System.out.println(rs);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("values inserted");
    }
}
