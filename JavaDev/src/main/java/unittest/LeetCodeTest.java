package unittest;

import com.mwulib.LeetCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void TestReverseWord(){
        String sent = "This is a test";
        String rev = LeetCode.ReserveWord(sent);
        String[] words = rev.split(" ");
        Assert.assertEquals(words[0].equals("test"),true);

    }

    @Test
    public void TestReverseWord2(){
        String sent = "Th is ";
        String rev = LeetCode.ReverseWord2(sent);
        String[] words = rev.split(" ");
        Assert.assertEquals(words[0].equals("test"),true);
    }

    @Test
    public void TestL()
    {
        String sent = "Th is";
        String rev = LeetCode.reverseWords(sent);
        String[] words = rev.split(" ");
        Assert.assertEquals(words[0].equals("test"),true);
    }

    @Test
    public void TestAtoi(){
        String val = "  dafsd847adafd";
        String val2 = "  dafsd-847adafd";
        String val3 = "  dafsd-84844884884848848488488488484848848448487adafd";
        Integer ret = LeetCode.atoi(val);
        Integer ret2 = LeetCode.atoi(val2);
        Integer ret3 = LeetCode.atoi(val3);
        Assert.assertEquals(ret==847,true);
        Assert.assertEquals(ret2==-847,true);
        Assert.assertEquals(ret3==Integer.MIN_VALUE,true);
    }

    @Test
    public void isNumber(){
        String val1 = "    +4443.443";
        String val2 = "  -343.434";
        String val3 = "  -343.434a";
        Boolean ret1 = LeetCode.validNumber(val1);
        Boolean ret2 = LeetCode.validNumber(val2);
        Boolean ret3 = LeetCode.validNumber(val3);
        Assert.assertEquals(ret1,true);
        Assert.assertEquals(ret2,true);
        Assert.assertEquals(ret3,false);
    }

    @Test
    public void LongestSubAsciiCount(){
        String val1 = "abcbefghh950355j945381-%$^&";
        int ret1 = LeetCode.LonggestSubASCIICount(val1);


        Assert.assertEquals(ret1,12);
    }

    @Test
    public void LongestSubAsciiStr()
    {
        String val1 = "abcbefghh950355j945381-";
        String ret1 = LeetCode.LonggestSubASCII(val1);

        Assert.assertEquals(ret1.equals("j945381-"),true);

    }

    @Test
    public void TestAddOne()
    {
        List<Integer> t1 = new ArrayList<Integer>();
        t1.add(1);
        t1.add(2);
        t1.add(0);
        List<Integer> r1 = LeetCode.Plusone(t1);
        Assert.assertEquals(r1.get(2)==1,true);
        t1.add(9);
        List<Integer> r2 = LeetCode.Plusone(t1);
        Assert.assertEquals(r1.get(3)==0,true);
        Assert.assertEquals(r1.get(2)==2,true);

        t1 = new ArrayList<Integer>();
        t1.add(9);
        t1.add(9);
        r2 = LeetCode.Plusone(t1);
        Assert.assertEquals(t1.get(0)==1,true);
        Assert.assertEquals(t1.get(1)==0,true);
        Assert.assertEquals(t1.get(2)==0,true);
    }

    @Test
    public void TestNumPan(){
        boolean r1 = LeetCode.isPan(1991);
        Assert.assertEquals(r1,true);
    }

    @Test
    public void MaxSumSubArrayTest(){
        int[] a = new int[5];
        a[0] = 3;
        a[1] = 4;
        a[2] = -6;
        a[3] = 3;
        a[4] = -1;

        int max = LeetCode.MaxSumSubArray(a);

        Assert.assertEquals(max,7);

    }
}
