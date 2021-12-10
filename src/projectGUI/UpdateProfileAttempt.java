package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class UpdateProfileAttempt {
    //Creating the Text boxes and Combo boxes for users to input the information 
    private final JPanel updatePanel = new JPanel();
    private final JTextField adminID = new JTextField(10);
    private final JTextField lastname = new JTextField(10);
    private final JComboBox<String> chosenField = new JComboBox<>();
    private final JTextField inputField = new JTextField(10);
    //Creating a submit button
    private final JButton submit = new JButton("Submit");



    public UpdateProfileAttempt(){

        //Adds options to the Update Field Drop Down Box
        chosenField.addItem("First Name");
        chosenField.addItem("Last Name");
        chosenField.addItem("Address");
        chosenField.addItem("Phone Number");
        chosenField.addItem("Income");
        chosenField.addItem("Use");
        chosenField.addItem("Status");
        chosenField.addItem("Model");
        chosenField.addItem("Year");
        chosenField.addItem("Type");
        chosenField.addItem("Method");

//Adding an action listener to have the submit button move the information to Database.txt upon click
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            //Gets all the User Inputs from the boxes
                String id = adminID.getText();
                String last = lastname.getText();
                String update = (String) chosenField.getSelectedItem();

                int indexOfUpdate = getIndex(update);
                String Info2Update = inputField.getText();

                DBController prof = new DBController();
                getPath pathname = new getPath();
                Path path = pathname.getIt();
                boolean status = DBController.searchProfile(last, id, path);

                if (status){
                    prof.updateProfileByLastName(last, Info2Update, indexOfUpdate, id, path);
                    JOptionPane.showMessageDialog(null, "Success!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "The Profile does not exist");
                }
        }

        });
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
//Creates the final gui 
    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new UpdateProfileAttempt().updatePanel);
        f.add(updatePanel);
        f.add(new JLabel("Admin ID:", SwingConstants.RIGHT), f);
        f.add(adminID);
        f.add(new JLabel("Last Name:", SwingConstants.RIGHT), f);
        f.add(lastname);
        f.add(new JLabel("Select an Option:", SwingConstants.RIGHT), f);
        f.add(chosenField);
        f.add(new JLabel("Enter your update:", SwingConstants.RIGHT), f);
        f.add(inputField);
        f.add(submit);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        //Changes the size of the GUI frame
        f.setSize(200, 400);
    }
}
