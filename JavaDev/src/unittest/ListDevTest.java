package unittest;

import com.mwulib.ListDev;
import com.mwulib.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mwu on 6/7/15.
 */
public class ListDevTest {

    private List<Person> personList;

    public ListDevTest()
    {
        personList = Person.GenPersons(100);
    }

    @Test
    public void testGetHashMap() throws Exception {

        ListDev testDev = new ListDev();
        List<Person> personList = Person.GenPersons(100);


    }

    @Test
    public void testSort() throws Exception
    {
        ListDev testDev = new ListDev();

        List<Person> sortedPersons = new ArrayList<Person>(personList);

        String lastname = personList.get(0).getLastName();

        Assert.assertEquals(personList.get(0).getLastName(),sortedPersons.get(0).getLastName());

        Collections.sort(sortedPersons);

        Assert.assertNotEquals(personList.get(0).getLastName(),sortedPersons.get(0).getLastName());

        HashMap<String,Person> personHashMap = testDev.GetHashMap(personList);

        Person targetPeron = personHashMap.get(lastname);

        Assert.assertEquals("hashmap init fail",personHashMap.size(),100);
        Assert.assertNotNull(targetPeron);

        Assert.assertEquals("hashmap fail",lastname,targetPeron.getLastName());

    }

    @Test
    public void testRemove() throws  Exception
    {
        ListDev testDev = new ListDev();

        Person p = personList.get(0);
        HashMap<String,Person> personHashMap = testDev.GetHashMap(personList);
        Person.RemovePerson(personHashMap,p);

        Assert.assertEquals(personHashMap.size(),99);


    }
}