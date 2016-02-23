package views;

import dao.StudentDAO;
import dao.CourseDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Student;

public class ViewEnrolledCourses extends javax.swing.JFrame {
   private Student student;
   public ViewEnrolledCourses(Student student) {
      initComponents();
      this.student = student;
      CourseDAO cDao = new CourseDAO();
      DefaultTableModel model = (DefaultTableModel)courseTable.getModel();
      ArrayList<String> courses = cDao.getEnrolledCourse(student.getId());
      if(!courses.isEmpty()){
          System.out.println("It has something");
      }
      for (String course : courses) {
          //System.out.println(courses);
          model.addRow(new Object[]{course}); 
      }
      courseTable.setModel(model);
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        dropBtn = new javax.swing.JButton();
        cancelBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Student: Name");

        dropBtn.setText("Drop");
        dropBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropBtnActionPerformed(evt);
            }
        });

        cancelBtn1.setText("Cancel");
        cancelBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enrolled Courses:");

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(courseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dropBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
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
                    .addComponent(dropBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void dropBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropBtnActionPerformed
      // TODO add your handling code here:
        StudentDAO sDao = new StudentDAO();
        String courseCode = null;
        
        int row = -1;
	row = courseTable.getSelectedRow();
	if(row > -1){
            int end = courseTable.getRowCount() - 1;
            System.out.println("Index of Start: "+(row+1)+"; Index of End: "+end+"; Index of To: "+row);
            DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
            if(row!=end){
                model.moveRow(row+1, end, row);
            }
            courseCode = (String)courseTable.getModel().getValueAt(end, 0) + "";
            model.removeRow(end);
            courseTable.setModel(model);
	}
        
        sDao.dropCourse(student.getId(),courseCode);
   }//GEN-LAST:event_dropBtnActionPerformed

   private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
       new OptionsMenu(student).setVisible(true);
       this.dispose();
   }//GEN-LAST:event_cancelBtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn1;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton dropBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
