/*
 * 
 */
package gui.doctor;

import javax.swing.JFrame;

import startup.HospitalSystem;

// TODO: Auto-generated Javadoc
/**
 * The frame for the window to display the operations that involve doctor.
 */
public class DoctorOpsFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve doctor.
     */
    public DoctorOpsFrame() {
        setTitle("Doctor Operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        DoctorOpsPanel panel = new DoctorOpsPanel();
        add(panel);
    }

    /**
     * A main to run the GUI version of the hospital system that only involves doctor operations
     * and the ward.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.initialize();
        DoctorOpsFrame frame = new DoctorOpsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
