/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Roscoe Alicbusan
 */
public class Course {
    private String courseCode;
    private int units;
    private int maxNumberOfStudents;
    private int numEnrollees;

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
