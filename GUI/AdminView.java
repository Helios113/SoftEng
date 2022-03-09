package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
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
import DataUnits.Teacher;
import DataUnits.TeacherAvailability;
import DataUnits.TimeSlot;
import DataUnits.Training;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controllers.AdminController;
import Controllers.DirectorController;
import DataLists.DataList;
import DataUnits.CourseTime;

public class AdminView extends JPanel implements ActionListener, ListSelectionListener {
	
	JLabel label1 = new JLabel("<html><ol>" +
	"<li>Choose a course to assign.</li>"+
	"<li>Choose a Teacher</li>" +             
	"<li>Click 'Assign' to produce a stored Course->Teacher List.</li>" + 

	"</ol><html>");
	
	//Controller
	AdminController controller;
	// Buttons
	JButton assignButton;
	JButton saveButton;
	JButton returnButton;

	// Lists
	// JList<CourseRequirements> jListRequirements; // this will be course req
	JList<CourseTime> slotsToFill; // empty slots with no teacher assigned yet
	JList<TeacherAvailability> availableTeachers; // existing teachers' trainings

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

	public AdminView(GUI a, AdminController controller) {
		parent = a;
		this.controller = controller;
		this.setLayout(new GridBagLayout());
		displayArea = new JTextArea();
		displayArea.setPreferredSize(new Dimension(200, 200));

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(3,3,3,3);
		gbc.anchor = GridBagConstraints.NORTH;
		subGroup1 = new JPanel();
		subGroup2 = new JPanel();
		subGroup3 = new JPanel();
		subGroup1.setLayout(new GridBagLayout());
		subGroup2.setLayout(new GridBagLayout());
		subGroup3.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// newStuff
		gbc.gridx = 0;
		gbc.gridy = 1;
		subGroup3.add(displayArea, gbc);

		saveButton = new JButton("Produce List");
		saveButton.setActionCommand("Save");
		saveButton.addActionListener(this);
		gbc.gridy=2;
		gbc.gridx = 3;
		this.add(saveButton, gbc);
		gbc.gridx = 0;
		gbc.gridy=1;


		slotsToFill = new JList<CourseTime>();
		slotsToFill.setPreferredSize(new Dimension(200, 200));
		slotsToFill.addListSelectionListener(this);
		subGroup1.add(slotsToFill, gbc);

		availableTeachers = new JList<TeacherAvailability>();
		availableTeachers.setPreferredSize(new Dimension(200, 200));
		availableTeachers.addListSelectionListener(this);
		subGroup2.add(availableTeachers, gbc);

		assignButton = new JButton("Assign to course");
		assignButton.setActionCommand("Assign");
		assignButton.addActionListener(this);
		gbc.gridy = 2;
		subGroup2.add(assignButton, gbc);


		gbc.gridy=0;
		JLabel label1 = new JLabel("Select timeslot");
		subGroup1.add(label1, gbc);
		JLabel label2 = new JLabel("Select teacher");
		subGroup2.add(label2, gbc);
		JLabel label3 = new JLabel("Required training");
		subGroup3.add(label3, gbc);



		gbc.gridy=0;
		gbc.gridx=0;
		this.add(subGroup1, gbc);
		gbc.gridx=1;
		this.add(subGroup2, gbc);
		gbc.gridx=2;
		this.add(subGroup3, gbc);
		

		returnButton = new JButton("Back to main");
		returnButton.setActionCommand("Return");
		returnButton.addActionListener(a);
		gbc.gridx=3;
		this.add(returnButton, gbc);

	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Assign":
				availableTeachers.getSelectedValue().getTeacher()
						.addTimeSlot(slotsToFill.getSelectedValue());
				controller.removeTimeSlot(slotsToFill.getSelectedValue());
				updateViews();
				break;
			case "Save":
				controller.produceList(parent.getPath(FileTypes.timetable),parent.getPath(FileTypes.training_needed),parent.getPath(FileTypes.engagements));
				break;
		}

	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource().equals(slotsToFill)) {
			if (slotsToFill.getSelectedValue() != null) {
				availableTeachers.setListData(
						controller.filerTeachers(slotsToFill.getSelectedValue()).toArray(new TeacherAvailability[0]));
			}
			displayArea.setText("");
		}
		if (e.getSource().equals(availableTeachers)) {
			if(availableTeachers.getSelectedValue()!=null)
				displayArea.setText(availableTeachers.getSelectedValue().display());
			else{
				displayArea.setText("");
			}
		}
	}

	public void fillTimeSlots(DataList<CourseTime> t) {
		slotsToFill.setListData(t.toArray(new CourseTime[0]));
	}

	public void updateViews() {
		controller.populateCourse();
		availableTeachers.setListData(new TeacherAvailability[0]);
	}
}
