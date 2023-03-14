import java.sql.*;
import java.util.Scanner;

public class student {
    String name;
    int id;
    public void get_student_details()//gets the student details such as name and ID
    {
        Scanner input=new Scanner(System.in);//object of type Scanner
        System.out.println("Enter your name:");
        name=input.nextLine();//gets ur name
        System.out.println("Enter your id:");
        id=input.nextInt();//gets user ID
    }
    public void insert_details() throws SQLException, ClassNotFoundException//method to insert the details of student
    {
        dbconnection connection=new dbconnection("jdbc:mysql://localhost:3306/jdbc-1","root","root");//creates an object of type dbconnection class with name connection.name of the database id jdbc-1,user id is root and password is basketball30.
        Connection con=connection.getConnection();//establish the connection with the database "jdbc-1"
        String sql="insert into people values(?,?);";//sql statement for inserting the values given by the user in the table people.
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setInt(1,id);//map the first ? from the sql statement to the id
        stmt.setString(2,name);//map the first ? from the sql statement  to the name
        stmt.execute();//execute the SQL statement
        System.out.println("Record inserted Successfully");
        connection.closeConnection(con,stmt);//close the dbconnection with the method closeConnection in the dbconnection class
    }
    public void update_student_name() throws SQLException,ClassNotFoundException//method to update the details of student
    {
        dbconnection connection=new dbconnection("jdbc:mysql://localhost:3306/jdbc-1","root","root");//refer line 16
        Connection con=connection.getConnection();//refer line 17
        Scanner input=new Scanner(System.in);//refer line 9
        System.out.println("Enter your id");
        id=input.nextInt();//gets student ID from the user
        System.out.println("Enter your corrected name");
        String cname=input.next();//gets Student name from the user
        String sql="update people set first_name=? where id=?;";//sql statement to update the values in the table people.
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1,cname);//refer to line 21
        stmt.setInt(2,id);//refer to line 20
        int i = stmt.executeUpdate();
        if(i>0)//if valid record
            System.out.println("Record updated successfully");
        else//invalid record or record not found
            System.out.println("No such Record found");
        connection.closeConnection(con,stmt);//refer line 24
    }
    public void delete_student_record() throws SQLException, ClassNotFoundException// method to delete the data record of the particular student
    {
        dbconnection connection=new dbconnection("jdbc:mysql://localhost:3306/jdbc-1","root","root");//refer line 16
        Connection con=connection.getConnection();//refer line 17
        Scanner input=new Scanner(System.in);//refer line 9
        System.out.println("Enter your id:");
        id=input.nextInt();//gets StudentID from the user
        String sql="delete from people where id=?;";//sql statement for deleting the record in people where id=ID given by user in line above.
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setInt(1,id);//refer line 20
        int i=stmt.executeUpdate();
        if(i>0)//if valid record
        {
            System.out.println("Record deleted Successfully");
        }//if invalid record
        else
            System.out.println("Record not found");
        connection.closeConnection(con,stmt);//refer line 24
    }
    public void search_details() throws SQLException, ClassNotFoundException //method to search the details of the particular student
    {
        dbconnection connection=new dbconnection("jdbc:mysql://localhost:3306/jdbc-1","root","root");//refer line 16
        Connection con=connection.getConnection();//refer line 17
        Scanner input=new Scanner(System.in);//refer line 9
        System.out.println("Enter the id:");
        id=input.nextInt();//gets StudentID from the user
        String sql="select * from people where id=?;";//sql Statement for selecting the data where id=StudentID given by user in line above.
        PreparedStatement stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stmt.setInt(1,id);//refer line 20
        ResultSet rs=stmt.executeQuery();
        if(rs.next()==false)//if no record is there
            System.out.println("There is no such record");
        else//if a valid record exist
        {
            rs.previous();
            while (rs.next())
            {
                System.out.println(rs.getInt(1) + rs.getString(2));//prints the record of the StudentID entered
            }
        }
        connection.closeConnection(con,stmt);//refer line 24
    }
}

