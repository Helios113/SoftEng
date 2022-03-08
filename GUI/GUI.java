package GUI;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import Controllers.DirectorController;
import Controllers.AdminController;
import GUI.AdminView;

public class GUI extends JFrame implements ActionListener {
	private String dataPath;
	private final String COURSE_FILE = "Course_List.txt";
	private final String TRAINING_FILE = "Training_List.txt";
	private final String TIMESLOTS_FILE = "Course_Time_List.txt";
	private final String REQUIREMENTS_FILE = "Course_Req_List.txt";
	private final String TEACHER_FILE = "Teacher_List.txt";
	private final String TEACHER_ENGAGEMENT_FILE = "Teacher_Engagement_List.txt";
	private final String TEACHER_TRAINING_FILE = "Teacher_Training_List.txt";
	Container cPane;
	CardLayout cardLayout;
	JPanel cards;
	// Attributes
	final int HEIGHT = 400;
	final int WIDTH = (int)(HEIGHT * 2.5);
	DirectorView dv;
	DirectorController dc;

	AdminView av;
	AdminController ac;
	JPanel iv;

	public GUI() {  
		
		cPane = getContentPane();    
		cardLayout =new CardLayout(40,30);    
		cPane.setLayout(cardLayout);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set title
		this.setTitle("GUI Table");
		
		iv = new InitialView(this);
		cPane.add(iv, "Test1");



		dc = new DirectorController();
		dv = new DirectorView(this, dc);
		dc.setView(dv);
		cPane.add(dv, "Director");
		
		ac = new AdminController();
		av = new AdminView(this, ac);
		ac.setView(av);
		cPane.add(av, "Admin");
		
		
	}
	public void showGUI() {
		//setting to visible
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent e){  
		switch (e.getActionCommand())
		{
			case "Director":
				setDataDirector();
				cardLayout.show(cPane, "Director");
				break;
			case "Admin":
				setDataAdmin();
			 	cardLayout.show(cPane, "Admin");
			 	break;
			case "Return":
				cardLayout.show(cPane, "Test1");
				break;

		}
    }
	public void setDataPath(String path)
	{
		dataPath = path;
	}
	public String getPath(FileTypes A)
	{
		String cur;
		switch (A){
			case course:
				cur = COURSE_FILE;
				break;
			case training:
				cur= TRAINING_FILE;	
				break;
			case req:
				cur = REQUIREMENTS_FILE;
				break;
			case time:
				cur = TIMESLOTS_FILE;
				break;
			case teachers:
				cur = TEACHER_FILE;
				break;
			case engagements:
				cur = TEACHER_ENGAGEMENT_FILE;
				break;
			case teacherTraining:
				cur = TEACHER_TRAINING_FILE;
				break;
			default:
				cur = "";
				break;
		}
		Path filePath = Paths.get(dataPath,cur);
		System.out.println(filePath.toString());
		return filePath.toString();
	}
	public void setDataDirector()
	{
		dv.loadData();
	}
	public void setDataAdmin()
	{
		ac.setCourseData(getPath(FileTypes.course));
		ac.setReqData(getPath(FileTypes.req));
		ac.setTeacherData(getPath(FileTypes.teachers));
		ac.setTimeData(getPath(FileTypes.time));
		ac.setTrainingData(getPath(FileTypes.training));
		ac.setTeacherEngagementData(getPath(FileTypes.engagements));
		ac.setTeacherTrainingData(getPath(FileTypes.teacherTraining));
		ac.populateCourse();
		ac.populateTeachers();
	}
}