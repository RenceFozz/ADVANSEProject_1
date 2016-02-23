package views;

import dao.CourseDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Course;

public class ViewAllCourses extends javax.swing.JFrame {

   public ViewAllCourses() {
      initComponents();
      System.out.println("EOW");
      
      DefaultTableModel courseModel = (DefaultTableModel)courseTable.getModel();
      CourseDAO cd = new CourseDAO();
      
      for(int i=0;i<courseModel.getRowCount();i++){
         courseModel.removeRow(i);
      }
      
      ArrayList<Course> courses = cd.GetAllCourses();
      for (Course course : courses) {
         courseModel.addRow(course.getData());
      }
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jButton1 = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      courseTable = new javax.swing.JTable();
      Ok = new javax.swing.JButton();

      jButton1.setText("jButton1");

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      courseTable.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Course Code", "Units", "Max Students", "Enrolled Students"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }
      });
      jScrollPane1.setViewportView(courseTable);

      Ok.setText("Ok");
      Ok.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            OkActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(Ok)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Ok))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_OkActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton Ok;
   private javax.swing.JTable courseTable;
   private javax.swing.JButton jButton1;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
