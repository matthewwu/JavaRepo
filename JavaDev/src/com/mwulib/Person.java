package com.mwulib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by mwu on 6/5/15.
 */
public class Person implements Comparable<Person> {
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int hashCode()
    {
        return 31*FirstName.hashCode() + LastName.hashCode();
    }

    @Override
    public int compareTo(Person o) {
        Person p1 = (Person) o;
        int lastCmp = this.getLastName().compareTo(p1.getLastName());
        if(lastCmp == 0)
        {
            return this.getFirstName().compareTo(p1.getFirstName());
        }
        return lastCmp;
    }

    public static List<Person> GenPersons(int num)
    {
        List<Person> plist = new ArrayList<Person>();

        for(int i=1; i<=num;i++)
        {
            Person tmp = new Person();

            tmp.setLastName(UUID.randomUUID().toString());
            tmp.setFirstName(UUID.randomUUID().toString());
            plist.add(tmp);
        }

        return plist;

    }

    public static void RemovePerson(HashMap<String,Person> personHashMap,Person person)
    {
        if(personHashMap.containsKey(person.getLastName()))
        {
            personHashMap.remove(person.getLastName());
        }
    }

    public static HashMap<String,Person> GetHashMap(List<Person> personList)
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



    private String FirstName;
    private String LastName;
}
