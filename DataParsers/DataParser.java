package DataParsers;
import java.util.Scanner;

import DataLists.DataList;
import DataUnits.Data;

import java.io.File;

public class DataParser {
    public static <T extends Data> DataList<T> parseTraining(String fileLocation, Class<T> mode)
    {
        DataList<T> ret = new DataList<T>();
        System.out.println(fileLocation);
        File f = new File(fileLocation);
        Scanner scan;
        String line;
        try {
            scan = new Scanner(f);
            
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                line = line.strip(); //remove space
                String[] params = line.split(","); // split on commas
                T t = mode.getDeclaredConstructor(int.class,String.class).newInstance(Integer.parseInt(params[0]), params[1]);
                ret.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error! oh no");
        }
        return ret;
    }
}
