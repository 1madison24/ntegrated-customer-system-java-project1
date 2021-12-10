/*package projectGUI;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GUIDisplayAllProfiles {
    //Creating text boxes for user to input information
    private final JPanel dispAllProfiles = new JPanel();
    private final JTextField adminID = new JTextField(10);
    //Creating a select button
    private final JButton selectButton = new JButton("Select");
    private final JTextField lastName = new JTextField(10);

    public GUIDisplayAllProfiles(){
        //Creating an action listener to find the corresponding profile according to last name 
        selectButton.addActionListener(e -> {
            String id = adminID.getText();
            String last = lastName.getText();
            DBController funcCall = new DBController();
            getPath pathname = new getPath();
            Path path = pathname.getIt();
            boolean status = DBController.searchAllProfiles(id, path);
            
//If a profile is found get the information from Database.txt and send the information from the user

            if(status) {
                funcCall.getAllProfiles(id,path);
                //List<String> allProfiles = new ArrayList<>();

                List<String> theProf = DBController.getAllProfiles(id, path);

                //System.out.println(theProf);
                JFrame DispForm = new JFrame();
                DispForm.setLayout(new GridLayout());

                for(int index = 0; index < theProf.size(); index++) {

                    JLabel index = new JLabel("<html> Admin ID: " + theProf.get(0) + "<br/>First Name: " + theProf.get(1)
                            + "<br/>Last Name: " + theProf.get(2) + "<br/>Address: " + theProf.get(3) + "<br/>Phone: " + theProf.get(4) +
                            "<br/>Income: " + theProf.get(5) + "<br/>Use: " + theProf.get(6) + "<br/>Status: " + theProf.get(7) +
                            "<br/>Model: " + theProf.get(8) + "<br/>Year: " + theProf.get(9) + "<br/>Type: " + theProf.get(10) +
                            "<br/>Method: " + theProf.get(11) + "</html>");

                    DispForm.add(index);
                }

                DispForm.pack();
                DispForm.setVisible(true);
            }
            //If no profiles are left send message that there are not profiles left to display
            else {
                JOptionPane.showMessageDialog(null, "There are no profiles to display");
            }

        });
    }
    //Open actual GUI
    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new GUIDisplayAllProfiles().dispAllProfiles);
        f.add(new JLabel("Admin ID:", SwingConstants.LEFT), f);
        f.add(adminID);
        f.add(selectButton);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        //Change the size of the GUI frame
        f.setSize(150,400);
    }
}

 */
