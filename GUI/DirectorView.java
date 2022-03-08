package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import DataParsers.DataParser;
import DataUnits.Course;
import DataUnits.Data;
import DataUnits.TimeSlot;
import DataUnits.Training;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controllers.DirectorController;
import java.awt.Color;
public class DirectorView extends JPanel implements ActionListener, ListSelectionListener {

	// Controller
	DirectorController controller;

	// Buttons
	JButton returnButton;
	JButton addTrainingButton;
	JButton saveCourseButton;
	JButton addTimeButton;

	// Lists
	JList<Course> courseList;
	JList<Training> trainingList;

	// Combobox
	JComboBox<String> dayPicker;
	JComboBox<String> timePicker;

	// Data for comboboxes
	String[] day = { "MON", "TUE", "WED", "THU", "FRI" };
	// int[] time = {9,10,11,12,13,14,15,16,17};
	String[] time = { "09", "10", "11", "12", "13", "14", "15", "16", "17" };

	// File Chooser
	JFileChooser j;
	int r;
	int t;

	// JPanels
	GridBagConstraints gbc;
	JPanel subGroup1;
	JPanel subGroup2;
	JPanel subGroup3;

	JTextArea displayArea;
	Course c;
	GUI parent;
	public DirectorView(GUI a, DirectorController controller) {
		parent = a;
		this.controller = controller;

		displayArea = new JTextArea();
		displayArea.setPreferredSize(new Dimension(200, 200));

		gbc = new GridBagConstraints();
		subGroup1 = new JPanel();
		subGroup2 = new JPanel();
		subGroup3 = new JPanel();
		subGroup1.setLayout(new GridBagLayout());
		subGroup2.setLayout(new GridBagLayout());
		subGroup3.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;

	
		

		gbc.gridy = 2;
		saveCourseButton = new JButton("Save List");
		saveCourseButton.setActionCommand("SaveCourse");
		saveCourseButton.addActionListener(this);
		subGroup1.add(saveCourseButton, gbc);
		addTrainingButton = new JButton("Add Training to Course");
		addTrainingButton.setActionCommand("AddTraining");
		addTrainingButton.addActionListener(this);
		subGroup2.add(addTrainingButton, gbc);

		returnButton = new JButton("Back to main");
		returnButton.setBackground(Color.RED);
		returnButton.setActionCommand("Return");
		returnButton.addActionListener(a);

		dayPicker = new JComboBox<String>(day);
		timePicker = new JComboBox<String>(time);

		addTimeButton = new JButton("Add timeslot");
		addTimeButton.setBackground(Color.blue);
		addTimeButton.setActionCommand("AddTime");
		addTimeButton.addActionListener(this);
		gbc.gridy=0;
		subGroup3.add(displayArea,gbc);
		gbc.gridy=1;
		subGroup3.add(dayPicker,gbc);
		gbc.gridx=1;
		subGroup3.add(timePicker,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		subGroup3.add(addTimeButton,gbc);


		gbc.gridy = 1;
		courseList = new JList<>();
		courseList.setPreferredSize(new Dimension(200, 200));
		courseList.addListSelectionListener(this);
		subGroup1.add(courseList, gbc);

		trainingList = new JList<>();
		trainingList.setPreferredSize(new Dimension(200, 200));
		subGroup2.add(trainingList, gbc);



		this.add(subGroup1);
		this.add(subGroup2);
		this.add(subGroup3);

		this.add(returnButton);

	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "AddTime":
				c = courseList.getSelectedValue();
				if(c==null)
					break;
				r = c.getId();
				System.out.println(timePicker.getSelectedItem().toString());
				System.out.println(dayPicker.getSelectedItem().toString());
				controller.addTimeSlot(r,
						new TimeSlot(timePicker.getSelectedItem().toString(), dayPicker.getSelectedItem().toString()));
				updateList(courseList.getSelectedIndex());
				break;
			case "AddTraining":
				t = trainingList.getSelectedIndex();
				if(t==-1)
					break;
				c = courseList.getSelectedValue();
				if(c==null)
					break;
				r = c.getId();
				System.out.println(r+" "+ t);
				controller.addTraining(r, trainingList.getModel().getElementAt(t));
				updateList(courseList.getSelectedIndex());
				break;
			case "SaveCourse":
				controller.saveReqData(parent.getPath(FileTypes.req));
				controller.saveTimeData(parent.getPath(FileTypes.time));
				break;
		}
	}

	public void valueChanged(ListSelectionEvent e)
	{
		if(courseList.getSelectedValue()!=null)
			displayArea.setText(courseList.getSelectedValue().display());
	}

	public void setCourseList(String path) {
		controller.setCourseData(path);
		System.out.println(path);
		courseList.setListData(controller.getCourseData().toArray(new Course[0]));
	}

	public void setTrainingList(String path) {
		controller.setTrainingData(path);
		System.out.println(path);
		trainingList.setListData(controller.getTrainingData().toArray(new Training[0]));
	}

	public void updateList(int k) {
		if(controller.getCourseData()!=null){
			courseList.setListData(controller.getCourseData().toArray(new Course[0]));
			courseList.setSelectedIndex(k);
		}
		if(controller.getTrainingData()!=null)
			trainingList.setListData(controller.getTrainingData().toArray(new Training[0]));
	}

	public void loadData()
	{
		setCourseList(parent.getPath(FileTypes.course));
		setTrainingList(parent.getPath(FileTypes.training));
	}
}
