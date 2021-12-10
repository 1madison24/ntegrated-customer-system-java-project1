package projectGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSuccess {
    private JPanel delSuccess;
    private JButton OKButton;

    public DeleteSuccess(){
        //Adding the action listener in order to view the input from the DeleteProfile class
        //Creates a success message througg Jframe when profile is deleted 
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void openGUI(){
        JFrame f = new JFrame("Integrated Customer System");
        f.setContentPane(new DeleteSuccess().delSuccess);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
