import jdk.nashorn.internal.scripts.JD;

import java.sql.*;

/**
 * Created by Marcin on 2017-10-19.
 */
public class DataBaseController {
    public final String JDBC_DRIVER = "org.h2.Driver";
    public final String JDBC_URL = "jdbc:h2:" + ".my";
    public final String JDBC_USER = "root";
    public final String JDBC_PASSWORD = "";

    public DataBaseController(){
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            Connection con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
