package Controllers;
import javax.sound.sampled.DataLine;

import DataLists.DataList;
import DataParsers.DataWriter;
import DataParsers.DataParser;
import DataUnits.Course;
import DataUnits.TimeSlot;
import DataUnits.Training;
import GUI.DirectorView;

public class DirectorController {

    private DirectorView view;
    private String courseDataPath;
    private DataList<Course> courseList;

    private String trainingDataPath;
    private DataList<Training> trainingList;

    public void setView(DirectorView view){
        this.view = view;
    }

    public void setCourseData(String path)
    {
        courseDataPath = path;
        courseList = DataParser.parseData(courseDataPath, Course.class);
    }
    public DataList<Course> getCourseData()
    {
        return courseList;
    }

    public void setTrainingData(String path)
    {
        trainingDataPath = path;
        trainingList = DataParser.parseData(trainingDataPath, Training.class);
    }
    public DataList<Training> getTrainingData()
    {
        return trainingList;
    }
    public void addTraining(int i, Training t)
    {
        System.out.println(courseList.getByIndex(i) + " " + t.toString());
        courseList.getByIndex(i).addTraining(t);
    }
    public void addTimeSlot(int i, TimeSlot t)
    {
        courseList.getByIndex(i).addTimeSlot(t);
    }
    public void saveReqData(String path)
    {
        //todo
        DataWriter.writeCourseReq(path, courseList);
    }
    public void saveTimeData(String path)
    {
        //todo
        DataWriter.writeCourseTime(path, courseList);
    }
}