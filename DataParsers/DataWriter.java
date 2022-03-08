package DataParsers;

import java.io.FileWriter;
import java.io.IOException;

import DataLists.DataList;
import DataUnits.Course;
import DataUnits.CourseTime;
import DataUnits.Teacher;
import DataUnits.TimeSlot;
import DataUnits.Training;

public class DataWriter {
    public static void writeCourseTime(String path, DataList<Course> data) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (Course c : data) {
                for (TimeSlot t : c.getTimeSlots())
                    fw.write(String.format("%d,%s\n", c.getId(), t.toString()));
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fw == null)
                    return;
                fw.close();
            } catch (IOException e) {

            }
        }

    }

    public static void writeCourseReq(String path, DataList<Course> data) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (Course c : data) {
                for (Training t : c.getTrainingReqList())
                    fw.write(String.format("%d,%d\n", c.getId(), t.getId()));
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fw == null)
                    return;
                fw.close();
            } catch (IOException e) {

            }
        }
    }

    public static void writeTeacherTrainings(String path, DataList<Teacher> data) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (Teacher t : data) {
                for (Training tr : t.getTrainings()) {
                    fw.write(String.format("%s- %s\n", t.getName(), tr.getName()));
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fw == null)
                    return;
                fw.close();
            } catch (IOException e) {

            }
        }
    }

    public static void writeTeacherSchedule(String path, DataList<Teacher> data) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (Teacher t : data) {
                for (CourseTime tr : t.getTimeSlot()) {
                    fw.write(String.format("%s - %s - %s\n", tr.getCourse().getName(),  tr.getTimeSlot(), t.getName()));
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fw == null)
                    return;
                fw.close();
            } catch (IOException e) {

            }
        }
    }
    public static void writeTeacherEngagements(String path, DataList<Teacher> data)
    {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (Teacher t : data) {
                for (CourseTime tr : t.getTimeSlot()) {
                    fw.write(String.format("%d,%d,%s\n",t.getId(),tr.getId(),tr.getTimeSlot()));
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fw == null)
                    return;
                fw.close();
            } catch (IOException e) {

            }
        }
    }
}
