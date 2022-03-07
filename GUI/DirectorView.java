package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DataParsers.DataParser;
import DataUnits.Course;
import DataUnits.Data;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DirectorView extends JPanel implements ActionListener{

	JButton selectButton;
	JButton returnButton;
	JButton addTimeButton;
	JList<Data> courseList;
    public DirectorView(ActionListener a) {
        selectButton = new JButton("Choose Course List");
		returnButton = new JButton("Back to main");
		addTimeButton = new JButton("Add timeslot");
		selectButton.setActionCommand("Open");
		selectButton.addActionListener(this);
		returnButton.setActionCommand("Return");
		returnButton.addActionListener(a);
		addTimeButton.setActionCommand("Add");
		addTimeButton.addActionListener(this);
		courseList = new JList<>();
		this.add(selectButton);
		this.add(returnButton);
		this.add(courseList);
		this.add(addTimeButton);

    }
	public void actionPerformed(ActionEvent e){  
		switch (e.getActionCommand())
		{
			case "Open":
				JFileChooser j = new JFileChooser();
				int r = j.showOpenDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{
					setList(j.getSelectedFile().getAbsolutePath());
				}
				// if the user cancelled the operation
				else
					//setText("the user cancelled the operation");
				break;
			case "Add":
				courseList.getSelectedIndex();
				break;
		}
    }
	public void setList(String path)
	{
		System.out.println(path);
		courseList.setListData(DataParser.parseTraining(path, Course.class).toArray(new Course[0]));
	}

}
