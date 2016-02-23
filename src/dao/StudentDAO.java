package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Student;

public class StudentDAO {

    public Student getStudent(int ID) {
        try {
            // create a mysql database connection
            Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

      // create a sql date object so we can use it in our INSERT statemen
            // the mysql insert statement
            String query = "SELECT * FROM students where sID = ?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            int idNo;
            String name, password;
            Student s;
            ArrayList<String> courses = new ArrayList<>();
            CourseDAO cDao = new CourseDAO();
            if (rs.next()) {
                idNo = rs.getInt("sID");
                name = rs.getString("fullName");
                password = rs.getString("password");
                courses = cDao.getEnrolledCourse(idNo);
                s = new Student(name, idNo, password, courses);

                conn.close();
                return s;
            } else {

                conn.close();
                return null;
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addStudent(int sID, String name, String password) {
        try {
            // create a mysql database connection
            java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

            // create a sql date object so we can use it in our INSERT statemen
            // the mysql insert statement
            String query = "INSERT INTO students (sID, fullName, password)" + " values (?,?,?);";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, sID);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, password);
            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public void enrollCourse(int sID, String courseCode) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);
            String query = "INSERT INTO enrolledCourses (sID, courseCode)" + " values (?,?);";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, sID);
            preparedStmt.setString(2, courseCode);
            preparedStmt.execute();
            
            updateCount(courseCode);
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void dropCourse(int sID, String courseCode) {
        try {
            // create a mysql database connection
            java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

            // create a sql date object so we can use it in our INSERT statemen
            // the mysql insert statement
            String query = "DELETE FROM enrolledCourses WHERE sID = ? AND courseCode = ?;";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, sID);
            preparedStmt.setString(2, courseCode);

            // execute the preparedstatement
            preparedStmt.execute();
            updateCount(courseCode);
            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }
    
    public void updateCount(String courseCode){
        try {
            // create a mysql database connection
            java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);
            int count = 0;

            String query = "COUNT(SELECT sID FROM enrolledCourses WHERE courseCode = ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, courseCode);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

            query = "UPDATE courses set numOfEnrollees = ? where courseCode = ?;";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, count);
            preparedStmt.setString(2, courseCode);
            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

}
