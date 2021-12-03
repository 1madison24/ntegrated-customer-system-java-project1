package projectGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class IntCustSysMenu {
    private JButton selectButton = new JButton("Submit");
    private JPanel menuPanel = new JPanel();
    private JRadioButton createProfileRadioButton = new JRadioButton("Create Profile");
    private JRadioButton deleteProfileRadioButton = new JRadioButton("Delete Profile");
    private JRadioButton updateProfileRadioButton = new JRadioButton("Update Profile");
    private JRadioButton findDisplayProfileRadioButton = new JRadioButton("Find Profile");
    private JRadioButton displayAllProfilesRadioButton = new JRadioButton("Display All Profiles");
    ButtonGroup buttons = new ButtonGroup();


    public IntCustSysMenu() {

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (createProfileRadioButton.isSelected()) {
                    CreateProfile v = new CreateProfile();
                    v.openGUI();
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
    //public static void main(String[] args) {}

    public void openGUI() {
        buttons.add(createProfileRadioButton);
        buttons.add(deleteProfileRadioButton);
        buttons.add(updateProfileRadioButton);
        buttons.add(findDisplayProfileRadioButton);
        buttons.add(displayAllProfilesRadioButton);


        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new IntCustSysMenu().menuPanel);
        f.add(createProfileRadioButton);
        f.add(deleteProfileRadioButton);
        f.add(updateProfileRadioButton);
        f.add(findDisplayProfileRadioButton);
        f.add(displayAllProfilesRadioButton);
        f.add(selectButton);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setSize(200, 400);
    }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Path:\n");
            String strpath = in.nextLine();
            Path path = Paths.get(strpath);
    }
}