package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Course;

public class CourseDAO {

   public ArrayList courses = new ArrayList<>();

   public ArrayList<Course> getAllCourses() {
      try {
         // create our mysql database connection
         Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

         // our SQL SELECT query. 
         // if you only need a few columns, specify them by name instead of using "*"
         String query = "SELECT * FROM courses";

         // create the java statement
         Statement st = conn.createStatement();

         // execute the query, and get a java resultset
         ResultSet rs = st.executeQuery(query);

         // iterate through the java resultset
         while (rs.next()) {
            //String courseCode, int units, int maxNumberOfStudents, int numEnrollees
            String courseCode = rs.getString("courseCode");
            int units = rs.getInt("units");
            int maxStudent = rs.getInt("maxStudent");
            int numEnrollees = rs.getInt("numOfEnrollees");
            Course c = new Course(courseCode, units, maxStudent, numEnrollees);
            courses.add(c);

            // print the results
            //System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
         }
         st.close();
      } catch (Exception e) {
         System.err.println("Got an exception! ");
         System.err.println(e.getMessage());
      }

      return courses;
   }

   public ArrayList<String> getEnrolledCourse(int id) {
      ArrayList<String> courses = new ArrayList<>();

      try {
         // create our mysql database connection
         Connection conn = DriverManager.getConnection(Credentials.url, Credentials.username, Credentials.password);

          // our SQL SELECT query. 
         // if you only need a few columns, specify them by name instead of using "*"
         String query = "SELECT courseCode FROM enrolledCourses"
                 + "   WHERE sID = " + "'" + id + "';";

         // create the java statement
         Statement st = conn.createStatement();

         // execute the query, and get a java resultset
         ResultSet rs = st.executeQuery(query);

         // iterate through the java resultset
         while (rs.next()) {
            //String courseCode, int units, int maxNumberOfStudents, int numEnrollees
            String courseCode = rs.getString("courseCode");
            courses.add(courseCode);
         }
         st.close();
      } catch (Exception e) {
         System.err.println("Got an exception! ");
         System.err.println(e.getMessage());
      }

      return courses;
   }
}
