//
/*
package projectGUI;

import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;


public class UpdateProfile extends Container {
    private final JPanel updatePanel = new JPanel();
    private final JTextField admin = new JTextField(10);
    private final JTextField last = new JTextField(10);
    private final JComboBox<String> updateField = new JComboBox<>();
    private final JTextField inputField = new JTextField(10);
    private final JButton findButton = new JButton("Submit");

    public UpdateProfile() {

        //Adds options to the Update Field Drop Down Box
        updateField.addItem("First Name");
        updateField.addItem("Last Name");
        updateField.addItem("Address");
        updateField.addItem("Phone Number");
        updateField.addItem("Income");
        updateField.addItem("Use");
        updateField.addItem("Status");
        updateField.addItem("Model");
        updateField.addItem("Year");
        updateField.addItem("Type");
        updateField.addItem("Method");

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastName = last.getText();
                String adminID = admin.getText();
                String update = (String) updateField.getSelectedItem();
                //findButton.setVisible(false);
                DBController prof = new DBController();
                getPath path = new getPath();
                Path pathname = path.getIt();

                boolean status = prof.searchProfile(lastName, adminID, pathname);
                System.out.println(status);
                if (status) {
                    System.out.println(adminID);
                    UpdateProfile2 pan = new UpdateProfile2(adminID, lastName, update);
                    pan.openGUI(adminID, lastName, update);
                    //setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Profile Not Found");
                }
            }
        });
    }

    public void openGUI() {
        JFrame f = new JFrame("Integrated Patient System");
        f.setContentPane(new UpdateProfile().updatePanel);
        f.add(updatePanel);
        f.add(new JLabel("Admin ID:", SwingConstants.RIGHT), f);
        f.add(admin);
        f.add(new JLabel("Last Name:", SwingConstants.RIGHT), f);
        f.add(last);
        f.add(updateField);
        f.add(inputField);
        f.add(findButton);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setSize(200,400);
    }



}

 */
