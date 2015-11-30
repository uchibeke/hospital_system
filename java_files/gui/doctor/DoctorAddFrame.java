/*
 * 
 */
package gui.doctor;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The frame for the window to enter data for a new doctor, and cause the creation of the doctor.
 */
public class DoctorAddFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame to add a doctor.
     */
    public DoctorAddFrame() {
        setTitle("Doctor Addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        DoctorAddPanel panel = new DoctorAddPanel();
        add(panel);
    }

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
