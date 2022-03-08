package DataUnits;
import java.util.ArrayList;
import DataLists.DataList;
public class Teacher implements Data{
    int id;
    String name;
    DataList<Training> trainings;
    ArrayList<CourseTime> engagementSlots;
    public Teacher(int A, String n)
    {
        id = A;
        name = n;
        trainings = new DataList<Training>();
        engagementSlots = new ArrayList<CourseTime>();
    }
    public void addTraining(Training t)
    {
        trainings.add(t);
    }
    public void addTimeSlot(CourseTime t)
    {
        engagementSlots.add(t);
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
        return String.format("(%d,%s,%s)",id,name,trainings.toString());
    }
    public boolean isAvailable(TimeSlot t)
    {       
        for(CourseTime e : engagementSlots)
        {
            if(e.getTimeSlot().dow == t.dow && e.getTimeSlot().time == t.time)
                return false;
        }
        return true;
    }
    public ArrayList<Training> trainingsNeeded(DataList<Training> t)
    {
        ArrayList<Training> ret = new ArrayList<Training>();
        for(Training req : t)
        {
            if(!trainings.contains(req))
            {
                ret.add(req);
            }
        }
        return ret;
    }
    public ArrayList<CourseTime> getTimeSlot()
    {
        return engagementSlots;
    }
    public ArrayList<Training> getTrainings()
    {
        ArrayList<Training> ret = new ArrayList<Training>();
        for(CourseTime t: engagementSlots)
        {
            ret.addAll(trainingsNeeded(t.getCourse().getTrainingReqList()));
        }
        return ret;

    }
}
