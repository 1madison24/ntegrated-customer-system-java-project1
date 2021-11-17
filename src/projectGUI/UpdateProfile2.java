package projectGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class UpdateProfile2 {
    private JPanel update2;
    private JLabel adminID;
    private JLabel lastName;
    private JLabel updateChoice;
    private JTextField updateInfo;
    private JButton submitButton;


    public UpdateProfile2(String ID, String last, String choice) {

        writeLabels(ID, last, choice);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind = getIndex(choice);
                String info = updateInfo.getText();

                DBController prof = new DBController();
                getPath path = new getPath();
                Path pathname = path.getIt();

                prof.updateProfileByLastName(last, info, ind, ID, pathname);
                JOptionPane.showMessageDialog(null, "Success!");
            }
        });
    }

    public void openGUI(String ID, String last, String choice) {
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new UpdateProfile2(ID, last, choice).update2);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
    public void writeLabels(String ID, String last, String choice){
        adminID.setText("Admin ID: " + ID);
        lastName.setText("Patient Last Name: " + last);
        updateChoice.setText(choice + ": ");
    }

    public int getIndex(String update) {
        //get index gets a number for the field where the user wants to update in the profile
        int index = 0;

        if (update == "First Name") {
            index = 1;
        } else if (update == "Last Name") {
            index = 2;
        } else if (update == "Address") {
            index = 3;
        } else if (update == "Phone Number") {
            index = 4;
        } else if (update == "Income") {
            index = 5;
        } else if (update == "Insurance") {
            index = 6;
        } else if (update == "Use") {
            index = 7;
        } else if (update == "Status") {
            index = 8;
        } else if (update == "Model") {
            index = 9;
        } else if (update == "Year") {
            index = 10;
        } else if (update == "Type") {
            index = 11;
        } else if (update == "Method") {
            index = 12;
        } else {
            index = 13;
        }
        return index;
    }
}



