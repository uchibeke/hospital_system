/*
 * 
 */
package gui.doctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Doctor;
import gui.patient.PatientFrame;
// TODO: Auto-generated Javadoc
/**
 * A class to access a specific patient of a doctor. Class checks if patient is a patient of the doctor
 * then opens the frame for that patient
 *
 */
public class PatientAccessPanelInDoctor extends JPanel{
    /**
     * The text field for the entry of the patient's health number.
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If data is entered into the text field
     * that is not a valid int value, a brief error message is entered at the front of the text
     * field. Otherwise, a new window is created with the patient's data and operations on the
     * patient.
     *
     * @param doctor the doctor
     */
    public PatientAccessPanelInDoctor(Doctor doctor) {
        JLabel promptLabel = new JLabel("Access patient");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String valueAsString = textField.getText();
                int healthNum = -1;
                if (valueAsString != null && valueAsString.length() > 0) {
                    try {
                        healthNum = Integer.parseInt(valueAsString);
                    } catch (NumberFormatException e) {
                        textField.setText("Not int: " + textField.getText());
                        textField.revalidate();
                        return;
                    }
                    if (doctor.hasPatient(healthNum) ) {
                        PatientFrame frame = null;
                        try {
                            frame = new PatientFrame(healthNum);
                        } catch (RuntimeException e) {
                            textField.setText("Invalid id: " + textField.getText());
                            textField.revalidate();
                            return;
                        }
                        frame.setLocation(300, 300);
                        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        frame.setVisible(true);
                        textField.setText("");
                        textField.revalidate();
                    } else {
                        textField.setText("Not " + doctor.getName() + "'s patient." 
                    + textField.getText());
                        textField.revalidate();
                        
                    }
                    
                } else {
                    textField.setText("Empty field: " + textField.getText());
                    textField.revalidate();
                }
            }
        });
    }

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
    }

