package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

public class UpdateProfile2 {
    JButton submitButton;
    JLabel updateChoice; //update field

    JTextField updateInfo;    //update textfield
    JComboBox<String> UpdateDropDown; // update drop down
    UpdateProfile update2;   //update UpdateProfile.java
    CustomerProf.CustomerProf cusProf; //customer profile to update

    //private JPanel update2;
//    private JLabel adminID;
    private final JTextField adminID = new JTextField(10);
    private final JTextField lastName = new JTextField(10);
//    private JLabel lastName;


    public UpdateProfile2(String ID, String last, String choice) {
        System.out.println(ID);
        writeLabels(ID, last, choice);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind = getIndex(choice);
                String info = updateInfo.getText();

                DBController prof = new DBController();
                getPath path = new getPath();
                Path pathname = path.getIt();
                System.out.println(pathname);
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

    public void writeLabels(String ID, String last, String choice) {
        adminID.setText("Admin ID: " + ID);
        lastName.setText("Customer's Last Name: " + last);
        int index = getIndex(choice);
        System.out.println(index);
        System.out.println(last);
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
        } else if (update == "Use") {
            index = 6;
        } else if (update == "Status") {
            index = 7;
        } else if (update == "Model") {
            index = 8;
        } else if (update == "Year") {
            index = 9;
        } else if (update == "Type") {
            index = 10;
        } else if (update == "Method") {
            index = 11;
        } else {
            index = 12;
        }
        return index;
    }

    //we have the index when they choose from the drop down menu
    //so have that textbox ready for the user to input
    // given what the user puts in the UserFieldUpdate
    // update accordingly
    public UpdateCorrespondingProfile() {
        submitButton.addActionListener(e -> {
            String last = lastName.getText();
            String id = adminID.getText();
            DBController funcCall = new DBController();
            getPath pathname = new getPath();
            Path path = getPath.getIt();
            boolean status = DBController.searchProfile(last, id, path);
            if (status) {
                DBController.getProfileByLastName(last, id, path);
                List<String> theProf = DBController.getProfileByLastName(last, id, path);

                //maybe here we getText() from what the user inputted into the inputField


                DBController.updateProfileByLastName(String lastName, String updatedInfo, indexOfUpdate, String adminID, Path path);
            } else {
                JOptionPane.showMessageDialog(null, "Profile Not Found");
            }


            //now write code for updating based on what the selection was by the user in the drop down
            //AND while using what the user has inputted into the inputField textbook of what info they are using as replacement







        });
    }
}





