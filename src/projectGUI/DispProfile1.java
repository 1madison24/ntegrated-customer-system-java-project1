package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

public class DispProfile1 {
    private JPanel dispProf1 = new JPanel();
    private JTextField lastName = new JTextField(10);
    private JTextField adminID = new JTextField(10);
    private JButton selectButton = new JButton("Select");

    public DispProfile1(){
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String last = lastName.getText();
                String id = adminID.getText();
                DBController funcCall = new DBController();
                getPath pathname = new getPath();
                Path path = pathname.getIt();
                boolean status = funcCall.searchProfile(last, id, path);

                if(status) {
                    List<String> theProf = funcCall.getProfileByLastName(last, id, pathname.getIt());
                    DispForm2 prof = new DispForm2(theProf);
                    prof.openGUI(theProf);
                }
                else {
                    JOptionPane.showMessageDialog(null, "There is no such Profile");
                }
                }
            });
    }
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
        f.setSize(150,400);
    }
}
