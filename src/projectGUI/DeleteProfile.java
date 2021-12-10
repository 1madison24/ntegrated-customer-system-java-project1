package projectGUI;
import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.nio.file.Path;

public class DeleteProfile {
    //Creating the textboxes for users to type their username and last name 
    private final JPanel deletePanel = new JPanel();
    private final JTextField adminID = new JTextField(10);
    private final JTextField lastName = new JTextField(10);
    
    //Adding a submit button
    private final JButton submit = new JButton("Submit");

    public DeleteProfile(){
        //Adding an action listener to make the button get the profiles with the corresponding AdminID and last name and delete the profile
        submit.addActionListener(e -> {
            String last = lastName.getText();
            String id = adminID.getText();
            
//Creating a listener in order to view the Database.txt file in the getpath() class
            DBController funcCall = new DBController();
            getPath pathname = new getPath();
            Path path = pathname.getIt();

            boolean status = DBController.searchProfile(last, id, path);
            
//Creating an if statement that if a profile is found, it gets deleted from the Database.txt file and a JFrame "Success" appears
            if (status){
                funcCall.deleteProfileByLastname(last, id, path);
                JOptionPane.showMessageDialog(null, "Success!");
            }
            //No files are found so a Jframe "The profile does not exist appears
            else{
                JOptionPane.showMessageDialog(null, "The Profile does not exist");
            }
        });
    }
    //Creating the actual  gui 
    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new DeleteProfile().deletePanel);
        f.add(deletePanel);
        f.add(new JLabel("Admin ID:", SwingConstants.RIGHT), f);
        f.add(adminID);
        f.add(new JLabel("Last Name:", SwingConstants.RIGHT), f);
        f.add(lastName);
        f.add(submit);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        //Changing the size of the GUI frame 
        f.setSize(200, 400);
    }
}
