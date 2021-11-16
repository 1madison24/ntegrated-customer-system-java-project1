package projectGUI;

import javax.swing.*;
import java.util.List;

public class DispForm2 {
    public DispForm2(List<String> profile) {

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
    private JPanel disp2;

    public void openGUI(List<String> theProf) {
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new DispForm2(theProf).disp2);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
