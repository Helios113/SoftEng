package DataUnits;

import java.util.ArrayList;

public class TeacherAvailability {
    Teacher t;
    ArrayList<Training> trainingsRequired;
    public TeacherAvailability(Teacher t, ArrayList<Training> tr)
    {
        this.t = t;
        trainingsRequired = tr;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return t.getName();
    }
    public String display() {
        String ret = "";
        for(Training t:trainingsRequired)
        {
            ret+=t.toString()+'\n';
        }
        return ret;
    }
    public Teacher getTeacher()
    {
        return t;
    }
}
