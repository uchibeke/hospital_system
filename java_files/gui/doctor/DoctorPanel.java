/*
 * 
 */
package gui.doctor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import commands.DropAssocCommand;
import commands.AssignDoctorCommand;
import entities.Doctor;

// TODO: Auto-generated Javadoc
/**
 * The panel to display the information for a doctor, and accept operations on the doctor. The
 * panel gives the doctor's name. The patients of the doctors are not given, however,
 *  the user has the option to add another patient to the doctor or
 * remove a patient.
 */
public class DoctorPanel extends JPanel {
    /**
     * Create the panel to display the doctor's information and accept operations on the doctor.
     * 
     * @param doctor the doctor whose information is to be displayed and on whom operations can be
     *        done
     */
    public DoctorPanel(Doctor doctor) {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the patient information of the doctor is changed.
         */
        build(doctor);
    }

    /**
     * Fill in the panel to display the doctor's information and accept operations on the doctor.
     *
     * @param doctor the doctor
     */
    private void build (Doctor doctor) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Name: " + doctor.getName()));


        // add an empty panel to force the add doctor and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Add a panel to add a new patient to the doctor
        JPanel addDoctorPanel = addPatientPanel(doctor);
        add(addDoctorPanel);
        addDoctorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addDoctorPanel.setMaximumSize(addDoctorPanel.getPreferredSize());

        // add an empty panel to force the add doctor and exit components to the bottom
        JPanel emptyPanel2 = new JPanel();
        add(emptyPanel2);
        emptyPanel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Add a new panel to display a specific patient of the doctor.
        //Error message is display when user tries a access a patient not assigned to the doctor
        JPanel displayPatientPanel = displayPatient(doctor);
        add(displayPatientPanel);
        displayPatientPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPatientPanel.setMaximumSize(displayPatientPanel.getPreferredSize());

        // add an empty panel to force the add doctor and exit components to the bottom
        JPanel emptyPanel3 = new JPanel();
        add(emptyPanel3);
        emptyPanel3.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Add a new panel that allows user to remove a patient from the doctor
        JPanel removePatient = removePatient(doctor);
        add(removePatient);
        removePatient.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayPatientPanel.setMaximumSize(removePatient.getPreferredSize());
        
        //Add a panel with an exit button to exit the frame
        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }


    /**
     * A panel to add a doctor-patient association for this doctor. The panel as a prompt to enter
     * the doctor's name, and a field to enter the name.
     * 
     * @param doctor the current doctor
     * @return a panel to associate a new doctor with this patient
     */
    private JPanel addPatientPanel(final Doctor doctor) {
        JPanel addPatientPanel = new JPanel();
        addPatientPanel.add(new JLabel("Add patient"));
        final JTextField textField = new JTextField(10);
        addPatientPanel.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                int healthNumber = 0;
                try {
                    healthNumber = Integer.parseInt(valueAsString);
                } catch (NumberFormatException e) {
                    textField.setText("Not int: " + textField.getText());
                    textField.revalidate();
                    return;
                }
                AssignDoctorCommand addAssoc = new AssignDoctorCommand();
                addAssoc.assignDoctor(doctor.getName(), healthNumber);
                if (addAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(doctor);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog(DoctorPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addPatientPanel;
    }
    
    /**
     * A panel to display a specific patient of the doctor.
     *
     * @param doctor the doctor
     * @return displayPatient the created panel
     */
    private JPanel displayPatient(final Doctor doctor) {
        JPanel displayPatient = new JPanel();
        // add a panel with a field to access a specific patient
        PatientAccessPanelInDoctor accessPanel = new PatientAccessPanelInDoctor(doctor);
        add(accessPanel);
        add(Box.createVerticalGlue());
        return displayPatient;

    }
    

    
    /**
     * A panel to remove a specific patient.
     *
     * @param doctor the doctor
     * @return removePatient the created panel
     */
    private JPanel removePatient(final Doctor doctor) {
        JPanel removePatient = new JPanel();
        removePatient.add(new JLabel("Remove patient"));
        final JTextField textField = new JTextField(10);
        removePatient.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                int healthNumber = 0;
                try {
                    healthNumber = Integer.parseInt(valueAsString);
                } catch (NumberFormatException e) {
                    textField.setText("Not int: " + textField.getText());
                    textField.revalidate();
                    return;
                }
                DropAssocCommand drop = new DropAssocCommand();
                drop.dropAssociation(doctor.getName(), healthNumber);
                if (drop.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(doctor);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog(DoctorPanel.this, drop.getErrorMessage());
                }
            }
        });
        return removePatient;

    }
    

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
