/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class StudentDAO {
    
    public Student getStudent(int ID){
         try
    {
      // create a mysql database connection
      java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/advanse?" + "user=root&password=p@ssword");
     
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
      ArrayList<String> courses = new ArrayList<String>();
      if(rs.next()){
          idNo = rs.getInt("sID");
          name = rs.getString("fullName");
          password = rs.getString("password");
          s = new Student(name,idNo,password,courses);
          
          //getCourses
          
          
      conn.close();
          return s;
      }
      else{
          
          conn.close();
          return null;
      }
      
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        return null;
    }
}
