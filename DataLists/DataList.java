package DataLists;
import DataUnits.Data;
import DataUnits.Course;

import java.util.AbstractList;
import java.util.ArrayList;

public class DataList<T extends Data> extends AbstractList<T> {
    ArrayList<T> storage;
    
    
    public DataList()
    {
        storage = new ArrayList<T>();
    }
    public boolean contains(Course obj)
    {
        return storage.contains(obj);
    }
    public boolean contains(String obj)
    {
        for(T elem : storage)
        {
            if(elem.getName().equals(obj))
            {
                return true;
            }
        }
        return false;
    }
    public boolean contains(int obj)
    {
        for(T elem : storage)
        {
            if(elem.getId() == obj)
            {
                return true;
            }
        }
        return false;
    }
    public T get(int i)
    {
        return storage.get(i);
    }
    public T getByIndex(int i)
    {
        for(T elem : storage)
        {
            if(elem.getId() == i)
            {
                return elem;
            }
        }
        return null;
    }
    public T get(String i)
    {
        for(T elem : storage)
        {
            if(elem.getName().equals(i))
            {
                return elem;
            }
        }
        return null;
    }
    public boolean add(T elem)
    {
        if(contains(elem.getName())){
            System.out.println("element exists");
            return false;
        }
        return storage.add(elem);
    }
    public int size()
    {
        return storage.size();
    }
    public String toString()
    {
        String ret = "";
        for(T elem : storage)
        {
            if(!ret.equals(""))
                ret+=" ";
            ret+=elem.toString();
        }
        return ret;
    }
    public void remove(T A)
    {
        storage.remove(A);
    }
}
