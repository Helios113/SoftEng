package Controllers;
import javax.sound.sampled.DataLine;

import DataLists.DataList;
import DataParsers.DataWriter;
import DataParsers.DataParser;
import DataUnits.Course;
import DataUnits.TimeSlot;
import DataUnits.Training;
import GUI.DirectorView;
import GUI.ReportView;



public class ReportController {
ReportView rv;

public void setView(ReportView rv)
{
    this.rv = rv;
}
public void recip(String pathTimetable, String pathTrainingReq) {
    String timetable = DataParser.parseResults(pathTimetable);
    String trainingReq = DataParser.parseResults(pathTrainingReq);
    rv.updateInfo(timetable, trainingReq);
}
    
}