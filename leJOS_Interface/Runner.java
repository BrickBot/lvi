package leJOS_Interface;

import javax.swing.*;
import java.io.*;

public class Runner{
        public static void main(String args[]) {
                Splash splashScreen = new Splash("./Icons/LVIBig.jpg",
                        new java.awt.Frame());
                new leJOS_InterfaceMain();                
                splashScreen.setVisible(false);
                splashScreen = null;                
        }
}

