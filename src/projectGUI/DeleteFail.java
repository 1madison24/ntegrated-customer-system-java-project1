package projectGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFail {
    private JPanel deleteFail;
    private JButton OKButton;

    public DeleteFail(){
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
