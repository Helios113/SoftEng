package DataUnits;
import java.util.ArrayList;

public class Teacher{
    int id;
    String name;
    ArrayList<Training> trainings;
    ArrayList<TimeSlot> engagmentSlots;
    public Teacher(int A, String n)
    {
        id = A;
        name = n;
        trainings = new ArrayList<Training>();
        engagmentSlots = new ArrayList<TimeSlot>();
    }
    
}
