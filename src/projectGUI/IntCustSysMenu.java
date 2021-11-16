package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IntCustSysMenu {
    private JButton selectButton;
    private JPanel menuPanel;
    private JRadioButton createProfileRadioButton;
    private JRadioButton deleteProfileRadioButton;
    private JRadioButton updateProfileRadioButton;
    private JRadioButton findDisplayProfileRadioButton;
    private JRadioButton displayAllProfilesRadioButton;

    public IntCustSysMenu(){
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createProfileRadioButton.isSelected()) {
                    CreateProfile prof = new CreateProfile();
                    prof.openGUI();
                }
                if (deleteProfileRadioButton.isSelected()) {
                    DeleteProfile prof = new DeleteProfile();
                    prof.openGUI();
                }
                if (updateProfileRadioButton.isSelected()) {
                    UpdateProfile prof = new UpdateProfile();
                    prof.openGUI();
                }

                if (findDisplayProfileRadioButton.isSelected()) {
                    DispProfile1 prof = new DispProfile1();
                    prof.openGUI();
                }
                if (displayAllProfilesRadioButton.isSelected()) {
                    MultLogin prof = new MultLogin();
                    prof.openGUI();
                }
            }
        });
    }
    public static void main(String[] args){
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new IntCustSysMenu().menuPanel);
        f.setDefualtCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Path:\n");
        String strpath = in.nextLine();
        Path path = Paths.get(strpath);
    }
}
