package unittest;

import com.mwu.pattern.MySingleton;
import org.junit.Test;

/**
 * Created by mwu on 6/16/15.
 */
public class PatternTest {
    @Test
    public void TestSingleton(){
        MySingleton s = MySingleton.INSTANCE;
        s.Test();
    }
}
