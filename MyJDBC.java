import java.sql.*;
import java.util.Scanner;

public  class MyJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException //throws SQLException and ClassNotFoundException due to connectivity of SQL(JDBC)
    {
        student s = new student();//object of type student with name as "s".
        int Choice=0;
        do {
            System.out.println("Select an option\n1-Registration\n2-Update\n3-delete\n4-Search\n5-Exit");
            Scanner c = new Scanner(System.in);//gets the input from the user
            Choice = c.nextInt();
            switch (Choice) {
                case 1:
                    s.get_student_details();//calls the method get_student_details from the student class
                    s.insert_details();//calls the method insert_details from the student class
                    break;
                case 2:
                    s.update_student_name();//calls the method update_student_name from the student class
                    break;
                case 3:
                    s.delete_student_record();//calls the method delete_student_record from the student class
                    break;
                case 4:
                    s.search_details();//calls the method search_details from the student class
                    break;
                case 5:
                    System.out.println("Exiting the Application");//exits the application
                    break;
                default:
                    System.out.println("Choose a valid option");//in case of an invalid input(other than 1,2,3,4 and 5)
            }
        }while(Choice!=5);
    }
}
