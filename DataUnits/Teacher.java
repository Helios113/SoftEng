package DataUnits;
import java.util.ArrayList;
import DataLists.DataList;
public class Teacher implements Data{
    int id;
    String name;
    DataList<Training> trainings;
    ArrayList<TimeSlot> engagmentSlots;
    public Teacher(int A, String n)
    {
        id = A;
        name = n;
        trainings = new DataList<Training>();
        engagmentSlots = new ArrayList<TimeSlot>();
    }
    public void addTraining(Training t)
    {
        trainings.add(t);
    }
    public void addTimeSlot(TimeSlot t)
    {
        engagmentSlots.add(t);
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
    public boolean isAvailabe(TimeSlot t)
    {
        for(TimeSlot e : engagmentSlots)
        {
            if(e.dow == t.dow && e.time == t.time)
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
}
