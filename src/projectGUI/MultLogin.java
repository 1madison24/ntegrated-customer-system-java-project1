package projectGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
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
//                System.out.println(rightProfiles);
//                List<List<String>> rightProfiles = new ArrayList<List<String>>();

                if(rightProfiles.size() > 0){
//                    DisplayMultiple prof = new DisplayMultiple(rightProfiles);
//                    prof.openGUI(rightProfiles);
                    for (int i = 0; i < 12; i++) {
                        rightProfiles.remove(0);
                    }
                    if(rightProfiles.size() == 0){
                        JOptionPane.showMessageDialog(null, "There are no more profiles");
                    }
                    else{
                        JFrame DispForm = new JFrame();
                        DispForm.setLayout(new GridLayout());
                        JLabel a = new JLabel("<html> Admin ID: " + rightProfiles.get(0) + "<br/>First Name: " + rightProfiles.get(1)
                                + "<br/>Last Name: " + rightProfiles.get(2) + "<br/>Address: " + rightProfiles.get(3) + "<br/>Phone: " + rightProfiles.get(4) +
                                "<br/>Income: " + rightProfiles.get(5) + "<br/>Use: " + rightProfiles.get(6) + "<br/>Status: " + rightProfiles.get(7) +
                                "<br/>Model: " + rightProfiles.get(8) + "<br/>Year: " + rightProfiles.get(9) + "<br/>Type: " + rightProfiles.get(10) +
                                "<br/>Method: " + rightProfiles.get(11) + "</html>");
                        DispForm.add(a);
                        DispForm.pack();
                        DispForm.setVisible(true);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "There are no profiles with that Administrator ID");
                }
            }
        });
    }

    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");    //creates instance of a frame
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
