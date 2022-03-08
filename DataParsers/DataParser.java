package DataParsers;
import java.util.Scanner;

import DataLists.DataList;
import DataUnits.Data;

import java.io.File;
import java.util.ArrayList;

public class DataParser {
    public static <T extends Data> DataList<T> parseData(String fileLocation, Class<T> mode)
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
                System.out.println(params[0] +" "+params[1]);
                T t = mode.getDeclaredConstructor(int.class,String.class).newInstance(Integer.parseInt(params[0]), params[1]);
                ret.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error! oh no");
        }
        return ret;
    }
    public static ArrayList<int[]> parseData(String fileLocation)
    {
        ArrayList<int[]> ret = new ArrayList<int[]>();
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
                int[] t = {Integer.parseInt(params[0].strip()),Integer.parseInt(params[1].strip())};
                ret.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error! oh no");
        }
        return ret;
    }
}
