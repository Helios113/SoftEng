package DataUnits;
public class TimeSlot implements Data{
    int time = 0;
    DayOfWeek dow;
    public TimeSlot(String time, String dow)
    {
        this.time = Integer.parseInt(time);
        this.dow = DayOfWeek.valueOf(dow);
    }
    public TimeSlot(String time)
    {
        this.time = Integer.parseInt(time.substring(3));
        this.dow = DayOfWeek.valueOf(time.substring(0,3));
    }
    public String toString()
    {
        return String.format("%s%02d", dow.toString(),time);
    }
    @Override
    public String getName() {
        return String.format("%s%02d", dow.toString(),time);
    }
    @Override
    public int getId() {
        return time;
    }
}
