package base;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {


    public Connection getConn(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jw","root","123456");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


}
