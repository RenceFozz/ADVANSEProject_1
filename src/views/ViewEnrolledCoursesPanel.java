package views;

import models.Student;

public class ViewEnrolledCoursesPanel extends javax.swing.JPanel {
   private Student student;
   
   public ViewEnrolledCoursesPanel(Student student) {
      initComponents();
      jLabel2.setText(student.getName());
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      addBtn = new javax.swing.JButton();
      cancelBtn = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      courseTable = new javax.swing.JTable();
      jLabel2 = new javax.swing.JLabel();
      addBtn1 = new javax.swing.JButton();
      cancelBtn1 = new javax.swing.JButton();

      addBtn.setText("Add");
      addBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addBtnActionPerformed(evt);
         }
      });

      cancelBtn.setText("Cancel");
      cancelBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelBtnActionPerformed(evt);
         }
      });

      jLabel1.setText("Enrolled Courses:");

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

      jLabel2.setText("Student: Name");

      addBtn1.setText("Add");
      addBtn1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addBtn1ActionPerformed(evt);
         }
      });

      cancelBtn1.setText("Cancel");
      cancelBtn1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelBtn1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(addBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cancelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel1)))
            .addContainerGap(28, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(cancelBtn1)
               .addComponent(addBtn1))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
       new OptionsMenu(student).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_addBtn1ActionPerformed

    private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtn1ActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addBtn;
   private javax.swing.JButton addBtn1;
   private javax.swing.JButton cancelBtn;
   private javax.swing.JButton cancelBtn1;
   private javax.swing.JTable courseTable;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
