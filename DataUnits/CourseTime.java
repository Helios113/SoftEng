package DataUnits;

public class CourseTime implements Data{
    int courseID;
    Course c;
    TimeSlot timeSlot;
    public CourseTime(int id, String ts)
    {
        courseID = id;
        timeSlot = new TimeSlot(ts);
    }
    public void setCourse(Course c)
    {
        this.c = c; 
    }
    public int getId()
    {
        return courseID;
    }
    public String getName()
    {
        return timeSlot.toString();
    }
    public TimeSlot getTimeSlot()
    {
        return timeSlot;
    }
    public Course getCourse()
    {
        return c;
    }
    public String toString()
    {
        return String.format("%s:%s",c.getName(),timeSlot);
    }
}
