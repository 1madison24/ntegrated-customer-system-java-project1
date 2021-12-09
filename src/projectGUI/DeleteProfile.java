package projectGUI;
import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.nio.file.Path;

public class DeleteProfile {
    private final JPanel deletePanel = new JPanel();
    private final JTextField adminID = new JTextField(10);
    private final JTextField lastName = new JTextField(10);
    private final JButton submit = new JButton("Submit");

    public DeleteProfile(){
        submit.addActionListener(e -> {
            String last = lastName.getText();
            String id = adminID.getText();

            DBController funcCall = new DBController();
            getPath pathname = new getPath();
            Path path = getPath.getIt();
            boolean status = DBController.searchProfile(last, id, path);

            if (status){
                DBController.deleteProfileByLastname(last, id, path);
                JOptionPane.showMessageDialog(null, "Success!");
            }
            else{
                JOptionPane.showMessageDialog(null, "The Profile does not exist");
            }
        });
    }
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
        f.setSize(200, 400);
    }
}
