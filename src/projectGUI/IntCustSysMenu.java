package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class IntCustSysMenu {
    private JButton selectButton = new JButton("select button");
    private JPanel menuPanel = new JPanel();
    private JRadioButton createProfileRadioButton = new JRadioButton("Create Profile");
    private JRadioButton deleteProfileRadioButton = new JRadioButton("Delete Profile");
    private JRadioButton updateProfileRadioButton = new JRadioButton("Update Profile");
    private JRadioButton findDisplayProfileRadioButton = new JRadioButton("Find Profile");
    private JRadioButton displayAllProfilesRadioButton = new JRadioButton("Display All Profiles");


    public IntCustSysMenu() {

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Success!");
                if (createProfileRadioButton.isSelected()) {
                    CreateProfile v = new CreateProfile();
                    v.openGUI();
                }
                else if (deleteProfileRadioButton.isSelected()) {
                    DeleteProfile y = new DeleteProfile();
                    y.openGUI();
                }

                else if (updateProfileRadioButton.isSelected()) {
                    UpdateProfile z = new UpdateProfile();
                    z.openGUI();
                }

                else if (findDisplayProfileRadioButton.isSelected()) {
                    DispProfile1 j = new DispProfile1();
                    j.openGUI();
                }
                else if (displayAllProfilesRadioButton.isSelected()) {
                    MultLogin k = new MultLogin();
                    k.openGUI();
                }
            }
        });
    }
    //public static void main(String[] args) {}

    public void openGUI() {
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
