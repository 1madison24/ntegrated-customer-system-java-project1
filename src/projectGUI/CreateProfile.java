package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class CreateProfile {
    private JPanel createPanel;
    private JTextField admin;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField address;
    private JTextField phone;
    private JTextField income;
    private JComboBox comboBox1; // Use
    private JComboBox comboBox2; // Status
    private JTextField model;
    private JTextField year;
    private JComboBox comboBox3; //Type
    private JComboBox comboBox4; //Method
    private JButton submitButton;

    public CreateProfile() {
        //Adding the options to the Use drop down menu
        comboBox1.addItem("Business");
        comboBox1.addItem("Personal");
        comboBox1.addItem("Both");

        //Adding the options to the Status drop down menu
        comboBox2.addItem("Active");
        comboBox2.addItem("Inactive");

        //Adding the options to the Type drop down menu
        comboBox3.addItem("Sudan");
        comboBox3.addItem("Hatchback");
        comboBox3.addItem("Luxury");
        comboBox3.addItem("Sport");

        //Adding the options to the Method drop down menu
        comboBox4.addItem("New");
        comboBox4.addItem("Certified Pre-Owned");
        comboBox4.addItem("Used");
        comboBox4.addItem("Other");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List userProf = buildProf();
                DBController prof = new DBController();
                getPath pathname = new getPath();
                Path path = pathname.getIt();
                prof.addprofile(userProf, path);
                JOptionPane.showMessageDialog(null, "Success!");
            }
        });
    }
        public void openGui () {
            JFrame f = new JFrame("Integrated Customer System"); //creates an instance
            f.setContentPane(new CreateProfile().createPanel);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.pack();
            f.setVisible(true); //show the actual frame
        }

        public List<String> buildProf() {
            //Gets all the User Inputs from the boxes
            String id = admin.getText();
            String first = firstName.getText();
            String last = lastName.getText();
            String address = address.getText();
            String phone = phone.getText();
            String income = income.getText();
            String use = (String) comboBox1.getSelectedItem();
            String status = (String) comboBox2.getSelectedItem();
            String model = model.getText();
            String year = year.getText();
            String type = (String) comboBox3.getSelectedItem();
            String method = (String) comboBox4.getSelectedItem();

            //Puts the new user into a user Profile List
            List<String> profile = new ArrayList<>();
            profile.add(id);
            profile.add(first);
            profile.add(last);
            profile.add(address);
            profile.add(phone);
            profile.add(income);
            profile.add(use);
            profile.add(status);
            profile.add(model);
            profile.add(year);
            profile.add(type);
            profile.add(method);

            return profile;
        }
    }

