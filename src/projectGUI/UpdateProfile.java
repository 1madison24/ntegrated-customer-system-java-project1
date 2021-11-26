package projectGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;


public class UpdateProfile {
    private JPanel updatePanel = new JPanel();
    private JTextField admin = new JTextField(10);
    private JTextField last = new JTextField(10);
    private JComboBox updateField = new JComboBox();
    private JButton findButton = new JButton("Submit");

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

                DBController prof = new DBController();
                getPath path = new getPath();
                Path pathname = path.getIt();

                boolean status = prof.searchProfile(lastName, adminID, pathname);
                if (status) {
                    UpdateProfile2 pan = new UpdateProfile2(adminID, lastName, update);
                    pan.openGUI(adminID, lastName, update);
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
        f.add(findButton);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setSize(200,400);
    }
}
