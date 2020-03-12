/*
 * TableDemoPane.java
 *
 * Created on March 15, 2001, 9:38 AM
 */

package leJOS_Interface;

/**
 *
 * @author  Default
 * @version 
 */
public class AddCommandPane extends javax.swing.JDialog {

    /** Creates new form TableDemoPane */
    public AddCommandPane(java.awt.Frame parent,boolean modal) {
        super (parent, modal);
        initComponents ();
        pack ();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents () {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel ();
        jPanel2 = new javax.swing.JPanel ();
        jLabel1 = new javax.swing.JLabel ();
        jTextField1 = new javax.swing.JTextField ();
        jPanel3 = new javax.swing.JPanel ();
        jLabel2 = new javax.swing.JLabel ();
        jScrollPane1 = new javax.swing.JScrollPane ();
        jTextArea1 = new javax.swing.JTextArea ();
        jPanel4 = new javax.swing.JPanel ();
        jButton1 = new javax.swing.JButton ();
        jButton2 = new javax.swing.JButton ();
        jLabel3 = new javax.swing.JLabel ();
        setModal (true);
        setTitle ("Add an abbreviation...");
        setResizable (false);
        addWindowListener (new java.awt.event.WindowAdapter () {
            public void windowClosing (java.awt.event.WindowEvent evt) {
                closeDialog (evt);
            }
        }
        );

        jPanel1.setLayout (new java.awt.GridLayout (2, 1));

  
            jLabel1.setText ("Command Abbreviation");
    
            jPanel2.add (jLabel1);
    
            jTextField1.setPreferredSize (new java.awt.Dimension(150, 20));
    
            jPanel2.add (jTextField1);
    
          jPanel1.add (jPanel2);
  
  
            jLabel2.setText ("Full Command");
    
            jPanel3.add (jLabel2);
    
    
//             jTextArea1.setPreferredSize (new java.awt.Dimension(200, 100));
               
               jScrollPane1.setPreferredSize (new java.awt.Dimension(200, 100));
               
              jScrollPane1.setViewportView (jTextArea1);
      
            jPanel3.add (jScrollPane1);
    
          jPanel1.add (jPanel3);
  

        getContentPane ().add (jPanel1, java.awt.BorderLayout.CENTER);


          jButton1.setText ("Ok");
          jButton1.addActionListener (new java.awt.event.ActionListener () {
              public void actionPerformed (java.awt.event.ActionEvent evt) {
                  jButton1ActionPerformed (evt);
              }
          }
          );
  
          jPanel4.add (jButton1);
  
          jButton2.setText ("Cancel");
          jButton2.addActionListener (new java.awt.event.ActionListener () {
              public void actionPerformed (java.awt.event.ActionEvent evt) {
                  jButton2ActionPerformed (evt);
              }
          }
          );
  
          jPanel4.add (jButton2);
  

        getContentPane ().add (jPanel4, java.awt.BorderLayout.SOUTH);

        jLabel3.setText ("Add an Abbreviation");
        jLabel3.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        jLabel3.setFont (new java.awt.Font ("Dialog", 0, 18));


        getContentPane ().add (jLabel3, java.awt.BorderLayout.NORTH);

        pack ();
    }//GEN-END:initComponents

  private void jButton2ActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton1ActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        abbreviation[0] = jTextField1.getText();
        abbreviation[1] = jTextArea1.getText();
        dispose();
  }//GEN-LAST:event_jButton1ActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible (false);
        dispose ();
    }//GEN-LAST:event_closeDialog

    /**
    * @param args the command line arguments
    */
    public static void main (String args[]) {
        new AddCommandPane (new javax.swing.JFrame (), true).show ();
    }

    public String [] getAbbreviation(){
        return abbreviation;
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
    private String[] abbreviation = new String[3];    
}