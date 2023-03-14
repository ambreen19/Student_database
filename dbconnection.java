import java.sql.*;

public class dbconnection {
    String url;//url of the database in the local computer or localhost which is present in MySQL with name as jdbc-1
    String user;//user ID of MySQL in the local computer
    String password;//password of MySQL
    dbconnection(String url,String user,String password)//constructor of dbconnection
    {
        this.url=url;
        this.user=user;
        this.password=password;
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException//method to establish connection with the database. Would return Connection which could be used in the class  Student while creating the object of dbconnection to establish conneection
    {
        Connection con=null;
        Class.forName("com.mysql.cj.jdbc.Driver");//name of the Driver
        con=DriverManager.getConnection(url,user,password);//creating the connection with the mentioned url,user,password
        System.out.println("Connection established");
        return con;//would return the connection
    }
    public void closeConnection(Connection con,PreparedStatement stmt) throws SQLException//method to close the connection
    {
        stmt.close();//closes the SQL statement
        con.close();//closes dbconnection
        System.out.println("Connection is closed");
    }

}
