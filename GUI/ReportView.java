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

import Controllers.ReportController;



public class ReportView extends JPanel {
    JButton[] btns;
    JButton select;
    JFileChooser j;
    GUI parent;
    
    GridBagConstraints gbc;
	JPanel panel1;
	JPanel panel2;

    JTextArea timetable;
    JTextArea trainingReq;

    JButton returnButton;

    public ReportView(GUI a, ReportController controller)
    {
        super();
        parent = a;
        this.setLayout(new GridBagLayout());
                
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridy=0;
        gbc.gridx =0;
		JLabel label1 = new JLabel("Timetable");
        
		this.add(label1, gbc);
        gbc.gridx= 1;
		JLabel label2 = new JLabel("Trainings Required");
      
		this.add(label2, gbc);

        timetable = new JTextArea();
        trainingReq = new JTextArea();
        gbc.gridx = 0;
        gbc.gridy = 1;
        timetable.setPreferredSize(new Dimension(400, 200));
        this.add(timetable, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        trainingReq.setPreferredSize(new Dimension(200, 200));
        this.add(trainingReq, gbc);

        

		

        returnButton = new JButton("Back to main");
		returnButton.setActionCommand("Return");
		returnButton.addActionListener(a);
		gbc.gridx=3;
		this.add(returnButton, gbc);
    }

    public void updateInfo(String timeString, String trainingString) {
        trainingReq.setText(trainingString);
        timetable.setText(timeString);
    }
    

}
