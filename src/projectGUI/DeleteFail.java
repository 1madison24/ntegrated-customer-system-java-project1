package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFail {
    private JPanel deleteFail;
    private JButton OKButton;

    public DeleteFail(){
        //Adds an action listener that views the information from the DeleteProfile class
        //If profile did not delete or was not found then JFrame appears stating that the profile was not deleted
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
    public void openGUI(){
        JFrame f = new JFrame("Integrated Patient System");
        f.setContentPane(new DeleteFail().deleteFail);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
