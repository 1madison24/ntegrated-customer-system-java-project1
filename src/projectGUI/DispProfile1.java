package projectGUI;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

public class DispProfile1 {
    //Creating  text boxes to recieve user input
    private final JPanel dispProf1 = new JPanel();
    private final JTextField lastName = new JTextField(10);
    private final JTextField adminID = new JTextField(10);
    //Creating a select button
    private final JButton selectButton = new JButton("Select");

    public DispProfile1() {
        //Creating an action listener in order to get information from the getpath() class (the Database.txt file)
        selectButton.addActionListener(e -> {
            String last = lastName.getText();
            String id = adminID.getText();
            DBController funcCall = new DBController();
            getPath pathname = new getPath();
            Path path = pathname.getIt();
            boolean status = DBController.searchProfile(last, id, path);
            //If a profile was found with the corresponding last name print out profile information
            if (status) {
                funcCall.getProfileByLastName(last, id, path);

                List<String> theProf = DBController.getProfileByLastName(last, id, path);
                JFrame DispForm = new JFrame();
                DispForm.setLayout(new GridLayout());
                JLabel a = new JLabel("<html> Admin ID: " + theProf.get(0) + "<br/>First Name: " + theProf.get(1)
                        + "<br/>Last Name: " + theProf.get(2) + "<br/>Address: " + theProf.get(3) + "<br/>Phone: " + theProf.get(4) +
                        "<br/>Income: " + theProf.get(5) + "<br/>Use: " + theProf.get(6) + "<br/>Status: " + theProf.get(7) +
                        "<br/>Model: " + theProf.get(8) + "<br/>Year: " + theProf.get(9) + "<br/>Type: " + theProf.get(10) +
                        "<br/>Method: " + theProf.get(11) + "</html>");
                DispForm.add(a);
                DispForm.pack();
                DispForm.setVisible(true);

            }
            //If a profile is not found state there is no profile
            else {
                JOptionPane.showMessageDialog(null, "There is no such Profile");
            }
        });
    }
        //Creating the actual gui
        public void openGUI(){
            JFrame f = new JFrame("Integrated Customer System");
            f.setContentPane(new DispProfile1().dispProf1);
            f.add(new JLabel("Admin ID:", SwingConstants.LEFT), f);
            f.add(adminID);
            f.add(new JLabel("Last Name:", SwingConstants.LEFT), f);
            f.add(lastName);
            f.add(selectButton);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.pack();
            f.setVisible(true);
            //Changing the size of our gui frame
            f.setSize(150, 400);
        }
    }

