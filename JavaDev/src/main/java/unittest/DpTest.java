package unittest;

import com.DP.LongestIncSubSeq;
import com.DP.MaxProduct;
import com.DP.MinStepToOne;
import com.DP.UniquePath;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mwu on 7/11/15.
 */
public class DpTest {
    private MinStepToOne minStepToOne = new MinStepToOne();

    @Test
    public void TestMinStepCase1(){
        int val = 10;
        int step = minStepToOne.getMinSteps(val);
        Assert.assertEquals(step,3);

    }

    @Test
    public void TestMinStepCase2(){
        int val = 100;
        int step = minStepToOne.getMinSteps(val);
        Assert.assertEquals(step,7);

    }

    @Test
    public void LongestSubSeqCase1(){
        int[] arr = new int[5];
        arr = new int[]{5,6,1,2,2};
        LongestIncSubSeq liss = new LongestIncSubSeq();
        int result = liss.getLongestIncSubSeq(arr);
        Assert.assertEquals(result,3);
    }

    @Test
    public void LongestSubSeqCase2(){
        int[] arr = new int[5];
        arr = new int[]{5,6,7,1,2};
        LongestIncSubSeq liss = new LongestIncSubSeq();
        int result = liss.getLongestIncSubSeq(arr);
        Assert.assertEquals(result,3);
    }

    @Test
    public void LongestSubSeqCase3(){
        int[] arr = new int[5];
        arr = new int[]{5,6,7,1,14,9,10,11,12,3};
        LongestIncSubSeq liss = new LongestIncSubSeq();
        int result = liss.getLongestIncSubSeq(arr);
        Assert.assertEquals(result,4);
    }

    @Test
    public void TestMaxProductCase1(){
        int[] arr = new int[4];
        arr = new int[]{5,-3,2,3};
        MaxProduct mp = new MaxProduct();
        int result = mp.maxProduct(arr);
        Assert.assertEquals(6,result);
    }

    @Test
    public void TestUniquePathCase1(){
        UniquePath up = new UniquePath();
        int ret = up.getUniquePath(2, 2);
        Assert.assertEquals(ret,2);

        ret = up.getUniquePathEnc(2,2);
        Assert.assertEquals(ret,2);
    }

    @Test
    public void TestUniquePathCase2(){
        UniquePath up = new UniquePath();
        int ret = up.getUniquePath(3,3);
        Assert.assertEquals(ret,6);

        ret = up.getUniquePathEnc(3,3);
        Assert.assertEquals(ret,6);

    }
}
