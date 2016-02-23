package views;

import models.Student;

public class OptionsMenu extends javax.swing.JFrame {
   private Student student;
    public OptionsMenu(Student student) {
        initComponents(); 
        this.student = student;
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      enrollCoursesButton = new javax.swing.JToggleButton();
      allCoursesBtn = new javax.swing.JToggleButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      enrollCoursesButton.setText("View Enrolled Courses");
      enrollCoursesButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            enrollCoursesButtonActionPerformed(evt);
         }
      });

      allCoursesBtn.setText("View All Courses");
      allCoursesBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            allCoursesBtnActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(128, 128, 128)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(enrollCoursesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(allCoursesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(135, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(125, Short.MAX_VALUE)
            .addComponent(enrollCoursesButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(allCoursesBtn)
            .addGap(118, 118, 118))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void enrollCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollCoursesButtonActionPerformed
      new ViewEnrolledCourses(student).setVisible(true);
      this.dispose();
   }//GEN-LAST:event_enrollCoursesButtonActionPerformed

   private void allCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCoursesBtnActionPerformed
      new ViewAllCourses(student).setVisible(true);
      this.dispose();
   }//GEN-LAST:event_allCoursesBtnActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JToggleButton allCoursesBtn;
   private javax.swing.JToggleButton enrollCoursesButton;
   // End of variables declaration//GEN-END:variables
}
