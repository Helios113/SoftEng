package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialView extends JPanel implements ActionListener{
    JButton[] btns;
    JButton select;
    JFileChooser j;
    GUI parent;
    public InitialView(GUI e)
    {

        super();
        parent = e;
        btns = new JButton[2];
        String[] texts = {"Director","Admin"};
        for(int i =0;i<2;i++)
        {
            btns[i] = new JButton(texts[i]);
            btns[i].setActionCommand(texts[i]);
            btns[i].addActionListener(e);
            this.add(btns[i]);
        }
        select = new JButton("Select Data Directory");
        select.setActionCommand("Select");
        select.addActionListener(this);
        this.add(select);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Select"))
        {
            j = new JFileChooser(); 
            j.setCurrentDirectory(new java.io.File("."));
            j.setDialogTitle("Select Data Directory");
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            j.setAcceptAllFileFilterUsed(false);
            if (j.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(j.getSelectedFile().toString());
                parent.setDataPath(j.getSelectedFile().toString());
            }
        }
    }

    

}
