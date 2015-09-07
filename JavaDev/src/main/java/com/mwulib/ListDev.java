package com.mwulib;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by mwu on 6/5/15.
 */
public class ListDev {

    private List listA = new ArrayList<Person>();


    public void CollectionList()
    {
        //List
        Person p1 = new Person();
        p1.setFirstName("p1_first");
        p1.setLastName("p1_last");
        Person p2 = new Person();
        p1.setFirstName("p2_first");
        p1.setLastName("p2_last");
        listA.add(1);
        listA.add("2");
        listA.add(p1);


        List<Person> plist = new ArrayList<Person>();
        List<Person> pListClone = new ArrayList<Person>();
        plist.add(p1);
        plist.add(p2);

        Collections.sort(plist);
        Collections.copy(pListClone,plist);
        Iterator io = plist.iterator();
        while (io.hasNext())
        {
            Person itemP = (Person) io.next();
        }

        for(Person o : plist)
        {
            String fname = o.getFirstName();
        }

    }

    public HashMap<String,Person> GetHashMap(List<Person> personList)
    {

        HashMap<String,Person> PersonMapByLast = new HashMap<String,Person>();

        for(Person o : personList)
        {
            if(!PersonMapByLast.containsKey(o.getLastName()))
            {
                PersonMapByLast.put(o.getLastName(),o);
            }
        }

        return PersonMapByLast;
    }

    public void LinkedList(){
        LinkedList<Person> llPerson = new LinkedList<>();
        llPerson.add(new Person());

        Stack<Person> sPerson = new Stack<>();
        Iterator io = sPerson.iterator();
        while (io.hasNext()){

        }
        for(Person p: sPerson){

        }

        HashSet<Person> personHashSet = new HashSet<>();
        LinkedBlockingQueue<Person> lbq = new LinkedBlockingQueue<>();


    }
}


