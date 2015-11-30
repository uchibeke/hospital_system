/*
 * 
 */
package gui.mainWindow;

import javax.swing.JFrame;

import startup.HospitalSystem;

// TODO: Auto-generated Javadoc
/**
 * The frame for the window to display the operations of the system: The operations for patient, doctor and ward.
 */
public class MainOpsFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve patients.
     */
    public MainOpsFrame() {
        setTitle("Main Operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        MainOpsPanel panel = new MainOpsPanel();
        add(panel);
    }

    /**
     * A main to run the GUI version of the hospital system that only involves  operations
     * of the whole system.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.initialize();
        MainOpsFrame frame = new MainOpsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
