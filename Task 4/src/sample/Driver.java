package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {

    public static void OpenDB(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\edita\\OneDrive\\Рабочий стол\\food.db.db");
            c.setAutoCommit(false);


            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Food;" );

            while ( rs.next() ) {
                //int id = rs.getInt("id");
                //String  name = rs.getString("name");
                //int age  = rs.getInt("age");
                // String  address = rs.getString("address");
                //float salary = rs.getFloat("salary");
                String dishname= rs.getString("Food_name");
                String description = rs.getString("Description");
                int price= rs.getInt("Price");

                Main.menuData.add(new Menu(dishname, description,price ));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    }
