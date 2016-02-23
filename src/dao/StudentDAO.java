package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Student;

public class StudentDAO {

   public Student getStudent(int ID) {
      try {
         // create a mysql database connection
         java.sql.Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

      // create a sql date object so we can use it in our INSERT statemen
         // the mysql insert statement
         String query = "SELECT * FROM students where sID == ?;";

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
}
