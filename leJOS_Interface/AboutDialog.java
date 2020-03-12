package leJOS_Interface;
/*
 * AboutDialog.java
 * Copyright (C) 2001 Andy Gombos
 * gombos_2000@yahoo.com
 * http://www.geocities.com/gombos_2000/
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
public class AboutDialog extends javax.swing.JDialog {

        /** Creates new form AboutDialog */
        public AboutDialog(java.awt.Frame parent, boolean modal) {
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
                jLabel1 = new javax.swing.JLabel ();
                jLabel2 = new javax.swing.JLabel ();
                jLabel3 = new javax.swing.JLabel ();
                jPanel2 = new javax.swing.JPanel ();
                jButton1 = new javax.swing.JButton ();
                addWindowListener (new java.awt.event.WindowAdapter () {
                                           public void windowClosing (
                                                   java.awt.event.WindowEvent evt) {
                                                   closeDialog (evt);
                                           }
                                   }
                                  );

                jPanel1.setLayout (new java.awt.GridLayout (3, 1));

                jLabel1.setText ("leJOS Interface");
                jLabel1.setHorizontalAlignment (
                        javax.swing.SwingConstants.CENTER);

                jPanel1.add (jLabel1);

                jLabel2.setText ("A visual interface and editor for the leJOS alternative firmware");
                jLabel2.setHorizontalAlignment (
                        javax.swing.SwingConstants.CENTER);

                jPanel1.add (jLabel2);

                jLabel3.setText ("Written by Andy Gombos");
                jLabel3.setHorizontalAlignment (
                        javax.swing.SwingConstants.CENTER);

                jPanel1.add (jLabel3);


                getContentPane ().add (jPanel1,
                        java.awt.BorderLayout.CENTER);


                jButton1.setText ("Ok");
                jButton1.addActionListener (
                        new java.awt.event.ActionListener () {
                                                    public void actionPerformed (
                                                            java.awt.event.ActionEvent evt) {
                                                            jButton1ActionPerformed (
                                                                    evt);
                                                    }
                                            }
                                           );

                jPanel2.add (jButton1);


                getContentPane ().add (jPanel2,
                        java.awt.BorderLayout.SOUTH);

        }//GEN-END:initComponents

        private void jButton1ActionPerformed (
                java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                new AboutDialog (new javax.swing.JFrame (), true).show ();
        }


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JButton jButton1;
        // End of variables declaration//GEN-END:variables

}

