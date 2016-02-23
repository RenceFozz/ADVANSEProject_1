/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class CourseDAO {
    public ArrayList courses = new ArrayList<Course>();
    
    public ArrayList<Course> GetAllCourses(){
        try
    {
      // create our mysql database connection
      String myUrl = "jdbc:mysql://localhost/advanse";
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
       
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM courses";
 
      // create the java statement
      Statement st = conn.createStatement();
       
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
     
      // iterate through the java resultset
      while (rs.next())
      {
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
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
        
    return courses;
    }
    
    public ArrayList<String> getEnrolledCourse(int id){
        ArrayList courses = new ArrayList<String>();
        
        try
        {
          // create our mysql database connection
          String myUrl = "jdbc:mysql://localhost/advanse";
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT courseCode FROM enrolledCourses"
                  + "   WHERE sID = " + "'"+ id +"';";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);

          // iterate through the java resultset
          while (rs.next())
          {
            //String courseCode, int units, int maxNumberOfStudents, int numEnrollees
            String courseCode = rs.getString("courseCode");
            courses.add(courseCode);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }

        return courses;
    }
}
