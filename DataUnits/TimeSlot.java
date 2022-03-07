package DataUnits;
public class TimeSlot{
    int time = 0;
    DayOfWeek dow;
    public TimeSlot(String time, String dow)
    {
        this.time = Integer.parseInt(time);
        this.dow = DayOfWeek.valueOf(dow);
    }
    public String toString()
    {
        return String.format("%s%2d", dow.toString(),time);
    }
}
