package DataUnits;

public class Training implements Data{
    private int id;
    private String name;
    public Training(int i, String n)
    {
        id= i;
        name = n;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public String toString() {
        return String.format("%d-%s",id,name);
    }
}
