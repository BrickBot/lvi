package leJOS_Interface;

/**
 * @author
 * @version
 */

import javax.swing.*;
import java.awt.*;

public class Splash extends JWindow {
        /**
          * Creates a new Splash screen
          */

        public Splash(String imageFile, Frame f) {
                super(f);
                JLabel imageLabel = new JLabel(new ImageIcon(imageFile));
                getContentPane().add(imageLabel, BorderLayout.CENTER);
                pack();
                Dimension screenSize =
                        Toolkit.getDefaultToolkit().getScreenSize();
                Dimension labelSize = imageLabel.getPreferredSize();
                setLocation(screenSize.width / 2 - (labelSize.width / 2),
                        screenSize.height / 2 - (labelSize.height / 2));
                setVisible(true);
                toFront();
                screenSize = null;
                labelSize = null;

        }
}

// End of Splash.java


