package DataUnits;

public class TeacherEngagement {
    int teacherId;
    CourseTime courseTime;
    public TeacherEngagement(int id, CourseTime ct)
    {
        teacherId = id;
        courseTime = ct;
    }
    public int getID()
    {
        return teacherId;
    }
    public CourseTime getCourseTime()
    {
        return courseTime;
    }
}
