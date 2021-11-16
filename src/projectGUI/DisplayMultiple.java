package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

public class DisplayMultiple {
    public DisplayMultiple(List<String> profile){
        adminID.setText(profile.get(0));
        First.setText(profile.get(1));
        Last.setText(profile.get(2));
        address.setText(profile.get(3));
        phone.setText(profile.get(4));
        income.setText(profile.get(5));
        use.setText(profile.get(6));
        status.setText(profile.get(7));
        model.setText(profile.get(8));
        year.setText(profile.get(9));
        type.setText(profile.get(10));
        method.setText(profile.get(11));
        List<String> temp = profile;
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<12; i++){
                    temp.remove(0);
                }
                if(temp.size() == 0){
                    JOptionPane.showMessageDialog(null, "There are no more profiles");
                }
                else{
                    DisplayMultiple prof = new DisplayMultiple(temp);
                    prof.openGUI(temp);
                }
            }
        });
    }

    private JLabel adminID;
    private JLabel First;
    private JLabel Last;
    private JLabel address;
    private JLabel phone;
    private JLabel income;
    private JLabel use;
    private JLabel status;
    private JLabel model;
    private JLabel year;
    private JLabel type;
    private JLabel method;
    private JPanel dispMult;
    private JButton nextButton;

    public void openGUI(List<String> theProf){
        JFrame f = new JFrame("Integrated Customer System");    //creates instance of a frame
        f.setContentPane(new DisplayMultiple(theProf).dispMult);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true); //making the frame visible
    }
}