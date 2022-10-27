import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    public static void main( String args[]  ) {
        Connection c ;
        Statement stmt ;
        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test",
                            "postgres", "pg@abi123");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE GoldCoast " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println(e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}

