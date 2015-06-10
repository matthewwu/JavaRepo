package unittest;

import com.mwulib.LeetCode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mwu on 6/9/15.
 */
public class LeetCodeTest {

    @Test
    public void TestTwoSum()
    {
        int[] arr = new int[]{33,11,34,3,5,91,45,24,2,8,6};
        int[] result = LeetCode.TwoSum(arr,8);
        Assert.assertEquals(result[0],4);
        Assert.assertEquals(result[1],5);
    }

    @Test
    public void TestTwoSumSort()
    {
        int[] arr = new int[]{2,4,5,6,8,12,14,16};
        int[] result = LeetCode.TwoSum(arr,20);
        Assert.assertEquals(result[0],5);
        Assert.assertEquals(result[1],6);

    }

    @Test
    public void TestPad()
    {
        boolean ret = LeetCode.IsValidPalindrome("abcddcba");
        Assert.assertEquals(ret,true);

        ret = LeetCode.IsValidPalindrome("abcdcba");
        Assert.assertEquals(ret,true);
    }

}
