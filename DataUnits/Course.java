package DataUnits;
import java.util.ArrayList;

import DataLists.DataList;

public class Course implements Data{
    int id;
    String name;
    DataList<Training> trainingReqList;
    ArrayList<TimeSlot> timeSlots;
    public Course(int A, String t)
    {
        id = A;
        name = t;
        trainingReqList = new DataList<Training>();
        timeSlots = new ArrayList<TimeSlot>();
    }
    public void addTraining(Training t)
    {
        trainingReqList.add(t);
        System.out.println(trainingReqList);
    }
    public void addTimeSlot(TimeSlot t)
    {
        timeSlots.add(t);
    }
    public ArrayList<TimeSlot> getTimeSlots()
    {
        return timeSlots;
    }
    public DataList<Training> getTrainingReqList()
    {
        return trainingReqList;
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
        return name;
    }
    public String display()
    {
        String A = "";
        A += id+" "+name+'\n';
        A += "Trainings:\n";
        for(Training t: trainingReqList)
        {
            System.out.println(trainingReqList);
            if(t==null)
                continue;
            A += '\t'+ t.toString()+'\n';
        }
        A += "Time Slots:\n";
        for(TimeSlot t: timeSlots)
        {
            if(t==null)
                break;
            A += '\t'+ t.toString()+'\n';
        }
        return A;
    }
}
