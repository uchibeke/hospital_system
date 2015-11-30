/*
 * 
 */
package gui.doctor;

import javax.swing.JFrame;

import containers.DoctorSetAccess;
import entities.Doctor;

// TODO: Auto-generated Javadoc
/**
 * The frame for the window to display the information for a doctor, and accept operations on the
 * doctor.
 */
public class DoctorFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for a doctor.
     * 
     * @param name the health number of the doctor
     * @precond name is the name of a doctor
     */
    public DoctorFrame(String name) {
        Doctor doctor = DoctorSetAccess.dictionary().get(name);
        if (doctor != null) {
            setTitle(doctor.getName() + " (" + name + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            DoctorPanel panel = new DoctorPanel(doctor);
            add(panel);
        } else
            throw new RuntimeException("Invalid name: " + name);
    }

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
