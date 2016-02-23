package models;

public class Course {
    private String courseCode;
    private int units;
    private int maxNumberOfStudents;
    private int numEnrollees;

   public Course(String courseCode, int units, int maxNumberOfStudents, int numEnrollees) {
      this.courseCode = courseCode;
      this.units = units;
      this.maxNumberOfStudents = maxNumberOfStudents;
      this.numEnrollees = numEnrollees;
   }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public int getNumEnrollees() {
        return numEnrollees;
    }

    public void setNumEnrollees(int numEnrollees) {
        this.numEnrollees = numEnrollees;
    }
    
    
    
}
