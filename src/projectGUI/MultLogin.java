package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

public class MultLogin {
    private JTextField adminID = new JTextField(10);
    private JButton submit = new JButton("Submit");
    private JPanel multLog = new JPanel();

    public MultLogin() {

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = adminID.getText();

                DBController funcCall = new DBController(); //create instance of DBController
                getPath pathname = new getPath();           //get Path
                Path path = pathname.getIt();
                List<String> rightProfiles = funcCall.getAllProfiles(id, path);

                if(rightProfiles.size() > 0){
                    DisplayMultiple prof = new DisplayMultiple(rightProfiles);
                    prof.openGUI(rightProfiles);
                }
                else{
                    JOptionPane.showMessageDialog(null, "There are no with that adminID");
                }
            }
        });
    }

    public void openGUI(){
        JFrame f = new JFrame("Integrated Patient System");    //creates instance of a frame
        f.setContentPane(new MultLogin().multLog);
        f.add(new JLabel("Admin ID:", SwingConstants.LEFT), f);
        f.add(adminID);
        f.add(submit);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setSize(200,400);
    }
}

