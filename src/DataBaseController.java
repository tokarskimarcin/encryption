import java.sql.*;

/**
 * Created by Marcin on 2017-10-19.
 */
public class DataBaseController {
    public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    public final String JDBC_USER = "root";
    public final String JDBC_PASSWORD = "";
    private Connection con;
    private PreparedStatement insertPreparedStatement = null;
    private Statement stmt = null;

    public DataBaseController(){
        try
        {
            con = getDBConnection();
            con.close();
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }

    public void insert(byte[] encryptedBytes, byte[] key){
        try {
            con = getDBConnection();
            String insertQuery = "INSERT INTO TEST.ENCRYPTION" + "(encrypted, ckey) values" + "(?,?)";
            insertPreparedStatement = con.prepareStatement(insertQuery);
            insertPreparedStatement.setBytes(1, encryptedBytes);
            insertPreparedStatement.setBytes(2, key);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public byte[][] getLastRow(){
        byte[][] enckeyBytes = new byte[2][];
        try {
            con = getDBConnection();

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `encryption` ORDER BY ID DESC LIMIT 1");
            while (rs.next()) {
                enckeyBytes[0] = rs.getBytes("ckey");
                enckeyBytes[1] = rs.getBytes("encrypted");
            }

            stmt.close();
            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enckeyBytes;
    }

    private Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD );
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
