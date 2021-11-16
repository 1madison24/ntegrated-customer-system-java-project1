package projectGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class DeleteProfile {
    private JPanel deletePanel;
    private JTextField adminID;
    private JTextField lastName;
    private JButton submit;

    public DeleteProfile(){
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String last = lastName.getText();
                String id = adminID.getText();

                DBController funcCall = new DBController();
                getPath pathname = new getPath();
                Path path = pathname.getIt();
                boolean status = funcCall.searchProfile(last, id, path);

                if (status){
                    funcCall.deleteProfileByLastname(last, id, path);
                    JOptionPane.showMessageDialog(null, "Success!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "The Profile does not exist");
                }
            }
        });
    }
    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new DeleteProfile().deletePanel);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
