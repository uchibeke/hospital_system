/*
 * 
 */
package gui.mainWindow;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.WardFrame;
import gui.doctor.DoctorOpsFrame;
import gui.patient.PatientOpsFrame;

// TODO: Auto-generated Javadoc
/**
 * The panel for the operations of the whole system. 
 * There is a button to call up patient operation, a button to call up doctor operation ,
 * a button to call up ward and an exit button to hide the window with this frame.
 */
public class MainOpsPanel extends JPanel {
    /**
     * Create the panel for the operations of the system. 
     * There is a button to call up patient operation, a button to call up doctor operation ,
     * a button to call up ward and an exit button to hide the window with this frame.
     */
    public MainOpsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a button to go to patient operations
        JButton patientButton = new JButton("Start Patient Operations");
        patientButton.setMaximumSize(patientButton.getPreferredSize());
        add(patientButton);
        patientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        patientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              PatientOpsFrame frame = new PatientOpsFrame(); 
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to go to doctors operations
        JButton doctorButton = new JButton("Start Doctor Operations");
        doctorButton.setMaximumSize(doctorButton.getPreferredSize());
        add(doctorButton);
        doctorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        doctorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              DoctorOpsFrame frame = new DoctorOpsFrame(); 
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to go to ward operations
        JButton wardInfoButton = new JButton("Start Ward Operations");
        wardInfoButton.setMaximumSize(wardInfoButton.getPreferredSize());
        add(wardInfoButton);
        wardInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wardInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                WardFrame frame = new WardFrame(); 
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add an empty panel to force the exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add a button to exit from the window containing this panel 
        final JButton exitButton = new JButton("Terminate");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;
}
