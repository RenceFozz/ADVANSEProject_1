package models;

import java.util.ArrayList;

public class Student {
   private String name;
   private int id;
   private String password;
   private ArrayList<Course> courses;

   public Student(String name, int id, String password, ArrayList<Course> courses) {
      this.name = name;
      this.id = id;
      this.password = password;
      this.courses = courses;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public ArrayList<Course> getCourses() {
      return courses;
   }

   public void setCourses(ArrayList<Course> courses) {
      this.courses = courses;
   }
   
   
}