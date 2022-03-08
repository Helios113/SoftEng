package DataParsers;

import java.io.FileWriter;
import java.io.IOException;

import DataLists.DataList;
import DataUnits.Course;
import DataUnits.TimeSlot;
import DataUnits.Training;


public class DataWriter {
    public static void writeCourseTime(String path, DataList<Course> data)
    {
        FileWriter fw = null;
        try{
            fw = new FileWriter(path);
            for(Course c : data)
            {
                for(TimeSlot t : c.getTimeSlots())
                fw.write(String.format("%d,%s\n", c.getId(), t.toString()));
            }
        }
        catch (IOException e)
        {

        }
        finally{
            try{
                if(fw == null)
                    return;
                fw.close();
            }
            catch (IOException e){

            }
        }
        
    }

    public static void writeCourseReq(String path, DataList<Course> data)
    {
        FileWriter fw = null;
        try{
            fw = new FileWriter(path);
            for(Course c : data)
            {
                for(Training t : c.getTrainingReqList())
                fw.write(String.format("%d,%d\n", c.getId(), t.getId()));
            }
        }
        catch (IOException e)
        {

        }
        finally{
            try{
                if(fw == null)
                    return;
                fw.close();
            }
            catch (IOException e){

            }
        }
    }

    
}
