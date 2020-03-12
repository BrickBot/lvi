package leJOS_Interface;
/*
 * InterfaceErrors.java
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
public class InterfaceErrors {
        private javax.swing.JOptionPane optPane;
        public InterfaceErrors() {
                optPane = new javax.swing.JOptionPane();
        }
        /**
         Set an error, and then show the error dialog
         @param error the error as a string
         */

        public void InterfaceError(String error) {
                optPane.showMessageDialog(null, (Object) error, "An error has occured!",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
        }
}

