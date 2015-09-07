package unittest;

import com.Design.LRUCache;
import com.Design.Node;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mwulib.Person;
import org.apache.hadoop.yarn.state.Graph;
import org.junit.Test;

import java.security.Key;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwu on 7/13/15.
 */
public class LRUCacheTest {

    @Test
    public void TestCache(){
        Person p1 = new Person();
        p1.setLastName("Last1");


        LRUCache<String,Person> cache = new LRUCache<>(3);
        cache.setNode(p1.getLastName(),p1);
    }

    @Test
    public void tt(){
        LinkedHashMap<String,Person> linkedHashMap = new LinkedHashMap<>(20,2.0f,true);

    }
}
