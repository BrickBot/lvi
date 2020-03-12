package leJOS_Interface;
/*
 * DdocumentFrame.java
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
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import leJOS_Interface.JavaKit.*;

public class DocumentFrame extends JInternalFrame implements KeyListener {
        static int openFrames = 1;
        static final int xOffset = 30, yOffset = 30;
        private Color textBase;
        private boolean closeBrace;
        private boolean openBrace;
        private int oBraces;
        private int cBraces;
        private int lines;
        private char letter;
        private int offset;
        private String word = new String();
        private String fullwords[]; 
        private String keywords[]; 
        private int chars;
        private String sourceName;
        private JScrollPane scrollArea;
        private JEditorPane sourceArea;
        private String titleName;
        private File Source;
        private InterfaceErrors ie = new InterfaceErrors();
        protected UndoManager undo = new UndoManager();
        public DocumentFrame() {
                super("Document #" + openFrames, true, true, true, true);
                scrollArea = new JScrollPane();
                sourceArea = new JEditorPane();
                setUpEditorPane();
                scrollArea.setViewportView (sourceArea);
                getContentPane().add(scrollArea);
                setSize(500, 500);
                setLocation(xOffset * openFrames, yOffset * openFrames);
                sourceArea.addKeyListener(this);
                sourceArea.getDocument().addUndoableEditListener(
                        new leJOS_UndoableEditListener());
        }
        public void setUpEditorPane() {
                //set up the editor kit              
                JavaEditorKit kit = new JavaEditorKit();
                sourceArea.setEditorKitForContentType("text/java", kit);
                sourceArea.setContentType("text/java");
                sourceArea.setBackground(java.awt.Color.white);
                sourceArea.setFont(new Font("MonoSpaced", 0, 12));
                sourceArea.setEditable(true);
                sourceArea.setBackground(textBase);
                //Initalize the colorizing mode
                JavaContext styles = kit.getStylePreferences();
                Style s;
                s = styles.getStyleForScanValue(
                        Token.COMMENT.getScanValue());
                StyleConstants.setForeground(s, new Color(102, 153, 153));
                s = styles.getStyleForScanValue(
                        Token.STRINGVAL.getScanValue());
                StyleConstants.setForeground(s, new Color(102, 153, 102));
                Color keyword = new Color(102, 102, 255);
                for (int code = 70; code <= 130; code++) {
                        s = styles.getStyleForScanValue(code);
                        if (s != null) {
                                StyleConstants.setForeground(s, keyword);
                        }
                }
        }
        public void undoEdit() {
                undo.undo();
        }
        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
                letter = e.getKeyChar();
                //clear the word
                if (letter == ' ') {
                        word = "";
                }
                if (e.getKeyCode() == e.VK_BACK_SPACE) {
                        int wordLength = word.length();
                        word = word.substring(0, wordLength - 1);
                }
                //accept all other valid characters
                if (letter != ' ' &&
                        Character.isISOControl(letter) != true) {
                        Character cletter = new Character(letter);
                        word = word + cletter.toString();

                }
                for (int i = 0; i < keywords.length; i++) {
                        if (word.equals(keywords[i])) {
                                try {
                                        offset =
                                                sourceArea.getCaretPosition();
                                        int keyLen = keywords[i].length();
                                        offset = offset - keyLen;
                                        sourceArea.getDocument().
                                                remove(offset, keyLen);
                                        sourceArea.getDocument().
                                                insertString(offset,
                                                fullwords[i], null);
                                } catch (BadLocationException ble) {
                                        ie.InterfaceError(
                                                ble.getMessage());
                                }
                                word = "";
                        }
                }
                indent(e);
        }
        public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '}') {
                        closeBrace = true;
                        cBraces++;
                } else if (e.getKeyChar() == '{') {
                        openBrace = true;
                        oBraces++;
                }
        }

       

        private String generateTab(int tabLength) {
                //generate a tab for the auto-indent
                String tab = new String();
                int i;
                for (i = 0; i < tabLength; i++) {
                        tab = tab + " ";
                }
                return tab;
        }

        private void indent(KeyEvent e) {
                //indent the line
                if (e.getKeyCode() == e.VK_ENTER) {
                        if (openBrace == true) {
                                sourceArea.replaceSelection(
                                        generateTab(oBraces * 8));
                                openBrace = false;
                        }
                        if (closeBrace == true) {
                                sourceArea.replaceSelection( generateTab(
                                        (oBraces - cBraces) * 8));
                                closeBrace = false;
                        } else {
                                sourceArea.replaceSelection(
                                        generateTab((oBraces) * 8));
                                openBrace = false;
                        }

                        if (oBraces - cBraces <= 0) {
                                oBraces = 0;
                                cBraces = 0;
                        }
                }
        }
        public String selectDocument() {
                //choose a file to open                        
                JFileChooser SourceChooser = new JFileChooser();
                int scval = SourceChooser.showOpenDialog(this);
                if (scval == JFileChooser.APPROVE_OPTION) {
                        Source = SourceChooser.getSelectedFile();
                        titleName = Source.getName();
                }
                return titleName;
        }
        public boolean openDocument(File SourceFile) {
                //open a selected document
                try {
                        FileReader fr = new FileReader(SourceFile);
                        sourceArea.read(fr, null);
                        return true;
                } catch (IOException ioe) {
                        ie.InterfaceError(ioe.getMessage());
                        return false;
                }
        }

        public void saveFile(File SourceFile) {
                //save the current document
                try {
                        FileWriter fw = new FileWriter(SourceFile);
                        sourceArea.write(fw);
                } catch (IOException ioe) {
                        ie.InterfaceError(ioe.getMessage());
                }
        }

        public File getSourceFile() {
                //return the file being shown
                return Source;
        }
        public JEditorPane getTextArea() {
                return sourceArea;
        }
        public void setTextAreaColor(Color baseColor) {
                //set background color
                sourceArea.setBackground(baseColor);
                textBase = baseColor;
        }

        public void setSourceFile(File sourceFile) {
                //do we need?
                Source = sourceFile;
                setTitle(Source.getName());
        }
        public boolean openSavedDocument() {
                //convenience method
                sourceName = selectDocument();
                File sourceFile = Source;
                if (openDocument(sourceFile)) {
                        setTitle(sourceName);
                        setSize(500, 500);
                        return true;
                }
                return false;
        }
        public void setShortcuts(String [] [] shortcuts){
                keywords = null;
                fullwords = null;
                keywords = new String[shortcuts.length];
                fullwords = new String[shortcuts.length];
                for (int i=0;i<shortcuts.length;i++)
                {
                        keywords[i] = shortcuts [i] [0];
                        fullwords[i] = shortcuts [i] [1];
                }
           }
        public void setClosedFrame(int frames) {
                openFrames = frames;
        }
        public void addNewFrame(int frames) {
                openFrames = frames + 1;
        }
        public void setDocumentTitle(String title) {
                setTitle(title);
        }

        protected class leJOS_UndoableEditListener implements UndoableEditListener {
                public void undoableEditHappened(UndoableEditEvent e) {
                        undo.addEdit(e.getEdit());
                }
        }

}

