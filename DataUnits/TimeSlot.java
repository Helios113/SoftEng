package DataUnits;
public class TimeSlot {
    int time = 0;
    DayOfWeek dow;
    public TimeSlot(int time, DayOfWeek dow)
    {
        this.time = time;
        this.dow = dow;
    }
}
