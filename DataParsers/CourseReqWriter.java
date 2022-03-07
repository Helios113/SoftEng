package DataParsers;

import java.io.FileWriter;


public class CourseReqWriter {
    public static void writeCoursReq(String path, DataList<Course> data)
    {
        FileWriter fw = new FileWriter("out.txt");
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
    }
}
