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
            if(checkIfValid(sID,courseCode)){
                java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);
                String query = "INSERT INTO enrolledCourses (sID, courseCode)" + " values (?,?);";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, sID);
                preparedStmt.setString(2, courseCode);
                preparedStmt.execute();

                updateCount(courseCode);
                conn.close();
            }
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    public boolean checkIfValid(int sID, String courseCode){
        try{
            java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);
            Student s = getStudent(sID);
            int unitCount = 0;
            String tempCC = "";
            
            String query = "SELECT units FROM courses WHERE courseCode = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = null;
            
            for(String code: s.getCourses()){
                preparedStmt.setString(1, code);
                rs = preparedStmt.executeQuery();
                if(rs.next()){
                    unitCount += rs.getInt("units");
                }
            }
            
            query = "SELECT courseCode FROM ADVANSE.enrolledCourses WHERE sID = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, sID);
            rs = preparedStmt.executeQuery();
            while(rs.next()){
                tempCC = rs.getString("courseCode");
                if(tempCC.equals(courseCode)){
                    System.out.println(courseCode);
                    System.out.println(tempCC);
                    return false;
                }
            }
            
            query = "SELECT * FROM courses where courseCode = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, courseCode);
            rs = preparedStmt.executeQuery();
            if(rs.next()){
                int units = rs.getInt("units");
                int maxNo = rs.getInt("maxStudent");
                int numOfEnrollees = rs.getInt("numOfEnrollees");
                
                if(units + unitCount <= 9 && numOfEnrollees < maxNo){
                    return true;
                }
                else{
                    return false;
                }
            }
            
            else{
                return false;
            }
        } catch (Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return true;
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

            String query = "select COUNT(*) FROM enrolledcourses WHERE courseCode = ?;";
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
