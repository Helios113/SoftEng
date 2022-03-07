package DataUnits;
import java.util.ArrayList;

public class Course implements Data{
    int id;
    String name;
    ArrayList<Training> trainingReqList;
    ArrayList<TimeSlot> timeSlots;
    public Course(int A, String t)
    {
        id = A;
        name = t;
        trainingReqList = new ArrayList<Training>();
        timeSlots = new ArrayList<TimeSlot>();
    }
    public void addTraining(Training t)
    {
        trainingReqList.add(t);
    }
    public void addTimeSlot(TimeSlot t)
    {
        timeSlots.add(t);
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return String.format("(%d,%s,%s)",id,name,trainingReqList.toString());
    }
}
