package projectGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MultLogin {
    //Create text boxes for user input
    private JTextField adminID = new JTextField(10);
    //Create submit button
    private JButton submit = new JButton("Submit");
    private JPanel multLog = new JPanel();

    public MultLogin() {
//Add action listener to get information from Database.txt
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = adminID.getText();

                DBController funcCall = new DBController(); //create instance of DBController
                getPath pathname = new getPath();           //get Path
                Path path = pathname.getIt();
                //Convert the profile data base into a string 
                List<String> rightProfiles = funcCall.getAllProfiles(id, path);

                if(rightProfiles.size() > 0){
                    //if there are no profiles inform user
                    if(rightProfiles.size() == 0){
                        JOptionPane.showMessageDialog(null, "There are no more profiles");
                    }
                    //if profiles are found print information 
                    else{
                        JFrame DispForm = new JFrame();
                        DispForm.setLayout(new GridLayout());
                        JLabel a = new JLabel("<html> Admin ID: " + rightProfiles.get(0) + "<br/>First Name: " + rightProfiles.get(1)
                                + "<br/>Last Name: " + rightProfiles.get(2) + "<br/>Address: " + rightProfiles.get(3) + "<br/>Phone: " + rightProfiles.get(4) +
                                "<br/>Income: " + rightProfiles.get(5) + "<br/>Use: " + rightProfiles.get(6) + "<br/>Status: " + rightProfiles.get(7) +
                                "<br/>Model: " + rightProfiles.get(8) + "<br/>Year: " + rightProfiles.get(9) + "<br/>Type: " + rightProfiles.get(10) +
                                "<br/>Method: " + rightProfiles.get(11) + "</html>");
//Creating a next button
                        JButton Next = new JButton("Next");
                        Next.setBounds(275, 520, 150, 40);
                        Next.setFont(new Font("Courier", Font.PLAIN, 20));
                        //Add action listener for button that changes to the next profile
                        //Changes to the next profile by removing the first 12 inputs through a for loop
                        Next.addActionListener(alpha->{
                            if(rightProfiles.size() != 0) {
                                for (int i = 0; i < 12; i++) {
                                    rightProfiles.remove(0);
                                }
                                //Prints out information
                                a.setText("<html> Admin ID: " + rightProfiles.get(0) + "<br/>First Name: " + rightProfiles.get(1)
                                        + "<br/>Last Name: " + rightProfiles.get(2) + "<br/>Address: " + rightProfiles.get(3) + "<br/>Phone: " + rightProfiles.get(4) +
                                        "<br/>Income: " + rightProfiles.get(5) + "<br/>Use: " + rightProfiles.get(6) + "<br/>Status: " + rightProfiles.get(7) +
                                        "<br/>Model: " + rightProfiles.get(8) + "<br/>Year: " + rightProfiles.get(9) + "<br/>Type: " + rightProfiles.get(10) +
                                        "<br/>Method: " + rightProfiles.get(11) + "</html>");
                            }
                            else{
                                //If no more profiles are found inform user
                                JOptionPane.showMessageDialog(null, "There are no more profiles");
                            }
                        });

                        DispForm.add(a);
                        DispForm.add(Next);
                        DispForm.pack();
                        DispForm.setVisible(true);
                    }
                }
                //If there are no profiles print that there are none
                else {
                    JOptionPane.showMessageDialog(null, "There are no profiles with that Administrator ID");
                }
            }
        });
    }
//Opening up actual gui frame
    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");    //creates instance of a frame
        f.setContentPane(new MultLogin().multLog);
        f.add(new JLabel("Admin ID:", SwingConstants.LEFT), f);
        f.add(adminID);
        f.add(submit);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        //Changing the size of the frame
        f.setSize(200,400);
    }
}
