package GUI;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialView extends JPanel implements ActionListener{
    JButton[] btns;
    JButton select;
    JFileChooser j;
    GUI parent;
    
    GridBagConstraints gbc;
	JPanel panel1;
	JPanel panel2;

    JTextArea text;
    public InitialView(GUI e)
    {
        super();
        parent = e;
        JLabel label = new JLabel("<html><ol>" +
            "<li>Please select the directory with all data. (Data folder)</li>"+
            "<li>Select the view for the appropriate user.</li>" +             
            "<li>Director View will allow you to add teaching requirements for the term.</li>" + 
            "<li>Admin View will allow you to assign Teachers to Trainings.</li>" + 
            "</ol><html>");
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //panels
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());

        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());


        //Select data button
        select = new JButton("Select Data Directory");
        select.setActionCommand("Select");
        select.addActionListener(this);
        panel1.add(select, gbc);


        btns = new JButton[3];
        String[] texts = {"Director","Admin", "Report"};
        for(int i =0;i<3;i++)
        {
            btns[i] = new JButton(texts[i]);
            btns[i].setActionCommand(texts[i]);
            btns[i].addActionListener(e);
            gbc.gridy=i;
            panel2.add(btns[i], gbc);
        }

        this.setLayout(new GridBagLayout()); 
        gbc.gridy=0; 
        gbc.gridx=0;
        this.add(label, gbc);
        gbc.gridy=0;
        gbc.gridx=1;
        this.add(panel1,gbc);
        gbc.gridx=2;
        this.add(panel2,gbc);
        
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
