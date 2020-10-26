package selalu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class awalTahun {
    public static void main(String[] args) {
        awalTahun.testrunning();
    }

    static void testrunning(){
        try{

            //create our  postgresql database connection
            String myDriver = "org.postgresql.Driver"; 
            String myUrl = "jdbc:postgresql://localhost:5432/project1";

            //call driver jdbc
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "postgres", "123456");

            //our SQL SELECT query 
            //if you only a few coloumns, specify them by name instead of using "*"
            String query = "SELECT * from bayar_lunas where extract(month from date) in (01,02,03)";
        
            //create the java statement
            Statement st = conn.createStatement();

            //execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            //iterate through the java resultset
            while (rs.next()){
                //integer item = rs.getInt("item")
                String invoiceid = rs.getString("invoiceid");

                //print the result
                System.out.format("Terima kasih karena Anda telah melakukan pembayaran pada invoice %s. Anda berhak mendapatkan diskon awal tahun sebesar 10%%!\n", invoiceid);
            }
            st.close();
        }catch(SQLException | ClassNotFoundException e) {
            System.err.println("Got an exception!");
            throw new RuntimeException("Error during startup of service !!!");
            //System.err.println(e.getMessage());
        }
    }
    
}
