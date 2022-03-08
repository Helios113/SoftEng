package Controllers;

import DataLists.DataList;
import DataParsers.DataParser;
import DataUnits.Course;
import DataUnits.Training;
import GUI.AdminView;

import java.util.ArrayList;
import DataUnits.Teacher;
import DataUnits.TeacherAvailability;
import DataUnits.CourseTime;

public class AdminController {
    DataList<Course> courseList;
    DataList<Teacher> teacherList;
    ArrayList<int[]> teacherTrainingList;
    DataList<CourseTime> teacherEngagementList;
    DataList<Training> trainingList;
    ArrayList<int[]> requirementsList;
    DataList<CourseTime> timeList;
    AdminView av;

    public void setView(AdminView av)
    {
        this.av = av;
    }

    public void setCourseData(String path) {
        courseList = DataParser.parseData(path, Course.class);
    }

    public void setTeacherData(String path) {
        teacherList = DataParser.parseData(path, Teacher.class);
    }

    public void setTrainingData(String path) {
        trainingList = DataParser.parseData(path, Training.class);
    }

    public void setReqData(String path) {
        requirementsList = DataParser.parseData(path);
    }

    public void setTeacherTrainingData(String path) {
        teacherTrainingList = DataParser.parseData(path);
    }

    public void setTimeData(String path) {
        timeList = DataParser.parseData(path, CourseTime.class);
    }

    public void setTeacherEngagementData(String path) {
        teacherEngagementList = DataParser.parseData(path, CourseTime.class);
    }

    public void populateCourse() {
        for (int[] t : requirementsList) {
            courseList.getByIndex(t[0]).addTraining(trainingList.getByIndex(t[1]));
        }
        for (CourseTime t : timeList) {
            courseList.getByIndex(t.getId()).addTimeSlot(t.getTimeSlot());
            t.setCourse(courseList.getByIndex(t.getId()));
        }
        av.fillTimeSlots(timeList);

    }

    public void populateTeachers() {
        for (int[] t : teacherTrainingList) {
            teacherList.getByIndex(t[0]).addTraining(trainingList.getByIndex(t[1]));
        }
        for (CourseTime t : teacherEngagementList) {
            teacherList.getByIndex(t.getId()).addTimeSlot(t);
        }
    }

    public ArrayList<TeacherAvailability> filerTeachers(CourseTime ct) {
        ArrayList<TeacherAvailability> ret = new ArrayList<TeacherAvailability>();
        for (Teacher t : teacherList) {
            if (t.isAvailable(ct.getTimeSlot())) {
                ret.add(new TeacherAvailability(t, t.trainingsNeeded(ct.getCourse().getTrainingReqList())));
            }
        }
        return ret;
    }
    public void removeTimeSlot(CourseTime t)
    {
        timeList.remove(t);
    }
    public void produceList()
    {
        for(Teacher t : teacherList)
        {
            
        }
    }

}
