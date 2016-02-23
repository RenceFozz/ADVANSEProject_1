package views;

public class DropCourse extends javax.swing.JFrame {

   public DropCourse() {
      initComponents();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      enrolledCourseTable = new javax.swing.JScrollPane();
      jTable1 = new javax.swing.JTable();
      dropBtn = new javax.swing.JToggleButton();
      jLabel1 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jTable1.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
         },
         new String [] {
            "Course Code", "Units", "Max Students"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }
      });
      enrolledCourseTable.setViewportView(jTable1);

      dropBtn.setText("Drop Course");
      dropBtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            dropBtnActionPerformed(evt);
         }
      });

      jLabel1.setText("Enrolled Courses:");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(15, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(dropBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(enrolledCourseTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(enrolledCourseTable, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(dropBtn)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void dropBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropBtnActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_dropBtnActionPerformed

   /**
    * @param args the command line arguments
    */

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JToggleButton dropBtn;
   private javax.swing.JScrollPane enrolledCourseTable;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JTable jTable1;
   // End of variables declaration//GEN-END:variables
}
