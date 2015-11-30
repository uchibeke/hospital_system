/*
 * 
 */
package gui.doctor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import commands.AddDoctorCommand;
import gui.SplitString;
import gui.ValueEntryPanel;

// TODO: Auto-generated Javadoc
/**
 * The panel to obtain data for the creation of a doctor, and to cause the doctor to be created.
 */
public class DoctorAddPanel extends JPanel {
    /* Declare the components of the panel needed by inner classes. */

    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error = null;

    /**
     * A panel for the entry of the name of a new doctor.
     */
    ValueEntryPanel namePanel;

    /**
     * A check box to use the check if doctor is a surgeon while creating a new doctor.
     */
    JCheckBox JCheckBox = new JCheckBox ( "Surgeon?", false);

    /**
     * Create the panel to obtain data for the creation of a patient, and to cause the patient to be
     * created.
     */
    public DoctorAddPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a label with a prompt to enter the doctor data
        JLabel prompt = new JLabel("Enter Doctor Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a panel with the field for the entry of the doctor's name
        namePanel = new ValueEntryPanel("name");
        namePanel.setMaximumSize(namePanel.getPreferredSize());
        add(namePanel);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
        

        // add a panel with radio button to chose if a doctor is a surgeon or not
        JCheckBox.setMaximumSize(JCheckBox.getPreferredSize());
        add(JCheckBox);
        JCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());

        // add a button to submit the information and create the doctor
        JButton submitButton = new JButton("Submit");
        submitButton.setMaximumSize(submitButton.getPreferredSize());
        add(submitButton);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitListener());
        add(Box.createVerticalGlue());
    }

    /**
     * The class listening for the press of the submit button. It accesses the name,
     * and uses it to add a new doctor to the system.
     *
     * @see SubmitEvent
     */
    private class SubmitListener implements ActionListener {
        
        /**
         * When the submit button is pressed, access the name  entered, and use
         * them to add a new Doctor to the system.
         *
         * @param event the event
         */
        public void actionPerformed(ActionEvent event) {
            if (error != null) {
                remove(error);
                error = null;
            }
            String name = namePanel.getValueAsString();
            AddDoctorCommand addDoctor = new AddDoctorCommand();
            addDoctor.addDoctor(name, JCheckBox.isSelected());
            if (addDoctor.wasSuccessful()) {
                getTopLevelAncestor().setVisible(false);
            } else {
                error = new JTextArea(SplitString.at(addDoctor.getErrorMessage(), 40));
                error.setMaximumSize(error.getPreferredSize());
                add(error);
                error.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(Box.createVerticalGlue());
                revalidate(); // redraw the window as it has changed
            }
        }
        
    }


    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
