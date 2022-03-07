package GUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class InitialView extends JPanel {
    JButton[] btns;

    public InitialView(ActionListener e)
    {
        super();
        btns = new JButton[3];
        String[] texts = {"Director", "Me", "Admin"};
        for(int i =0;i<3;i++)
        {
            btns[i] = new JButton(texts[i]);
            btns[i].setActionCommand(texts[i]);
            btns[i].addActionListener(e);
            this.add(btns[i]);
        }
    }
    

}
