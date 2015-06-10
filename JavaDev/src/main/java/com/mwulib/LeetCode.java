package com.mwulib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwu on 6/9/15.
 */
public class LeetCode {

    public static int[] TwoSum(int[] numbers, int target)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++)
        {
            if(map.containsKey(numbers[i])) {
               return new int[]{map.get(numbers[i])+1,i+1};
            }
            map.put(target - numbers[i], i);

        }
        throw new IllegalArgumentException("no two sum found");
    }

    public static int[] TwoSumSort(int[] numbers, int target)
    {
        int i=0;
        int j= numbers.length - 1;
        while(i<j){
            if(numbers[i]+numbers[j] == target)
            {
                return new int[]{i+1,j+1};
            }
            else if(numbers[i]+numbers[j]> target)
            {
                j--;
            }
            else {
                i++;
            }
        }
        throw new IllegalArgumentException("no two sum");
    }


    public static int BSearch(int[] numbers,int start,int target)
    {
        int l = start;
        int r = numbers.length - 1;
        while (l<r)
        {
            int m = (l+r)/2;
            if(numbers[m]==target){
                return m;
            }
            else if(target > numbers[m]){
                l = m+1;
            }
            else
            {
                r = m;
            }
        }

        return -1;
    }

    public static boolean IsValidPalindrome(String s)
    {
        int i = 0;
        int j = s.length();
        for(i=0;i<2/j;i++)
        {
            if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j-i-1)))
            {
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) !=Character.toLowerCase( s.charAt(j)))
            {
                return false;
            }
        }

        return true;
    }


}
