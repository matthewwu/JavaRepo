package com.mwulib;

import com.clearspring.analytics.util.ListNode2;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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
        if(l == r){
            return r+1;
        }

        return l;
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

    public static int strstr(String haystack,String str){
        for(int i=0;i<haystack.length();i++){
            for(int j=0;j<str.length();j++){

                if(str.charAt(j)!= haystack.charAt(i+j)){
                    break;
                }
                if(haystack.length()-i < str.length()) {//abcd kk
                    return -1;
                }
                if(j == str.length()-1)
                {
                    return i;
                }

            }
        }
        return -1;
    }

    public static String ReserveWord(String sent){
        String spliter = " ";
        String ret;
        String[] words = sent.split(spliter);
        for(int i=0;i<words.length/2;i++){
            String temp = words[i];
            words[i]= words[words.length-i-1];
            words[words.length-i-1] = temp;
        }
        return String.join(spliter,words);
    }

    public static String ReverseWord2(String sent){
        char[] csent = sent.toCharArray();
        Reverse(csent,0,csent.length);
        int start = 0;
        for(int i=0;i<csent.length; i++){
            if(csent[i] == ' ')
            {
                Reverse(csent,start,i);
                start = i + 1;
            }
            if(i== csent.length-1){
                Reverse(csent,start,i);
            }

        }

        return new String(csent);
    }

    public static void Reverse(char[] c,int start,int end){
        for(int i=0;i<(end - start)/2;i++){
            char tmp = c[i+start];
            c[i+start] = c[end -i-1];
            c[end-i-1]=tmp;
        }
    }

    public static String reverseWords(String sent) {
        char[] s = sent.toCharArray();
        reverse1(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse1(s, i, j);
                i = j + 1;
            } }
        return new String(s);
    }

    private static void reverse1(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        } }

    public static int atoi(String str){

        char[] c = str.toCharArray();
        int start=-1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i]) && start <0){
                start=i;
            }
            if(start>=0 && Character.isDigit(c[i]))
            {
                sb.append(c[i]);
            }
            if(start>=0 && !Character.isDigit(c[i])) {
                if(start==0 || (start>0 && c[start-1]=='+') || (start>0 && c[start-1] != '-')){

                    return tryParseInt(sb.toString(),true);
                }
                if(start>0 && c[start-1]=='-'){
                    return tryParseInt(sb.toString(),false);
                }

            }

        }
        return Integer.MAX_VALUE;
    }

    public static int tryParseInt(String value,boolean flag)
    {
        try
        {
            return Integer.parseInt(value);
        } catch(NumberFormatException nfe)
        {
            if(flag){
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }
    }

    public static Boolean validNumber(String s){
        s = s.trim();
        Boolean start = false;
        for(int i=0;i<s.length();i++) {
            if (!start && Character.isDigit(s.charAt(i))) {
                start = true;
            }
            if (start) {
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i)!='.') {
                    return false;
                }
            }
        }

        return true;
    }

    public static int LonggestSubASCIICount(String s){
        int max = 0;
        int j = 0;
        boolean[] exist = new boolean[256];

        for(int i=0;i < s.length();i++){
            while (exist[s.charAt(i)]){
                exist[s.charAt(j)] = false;
                j++;
            }
            exist[s.charAt(i)] = true;
            if(i-j+1 > max){
                max = i-j+1;
            }
        }

        return max;
    }

    public static String LonggestSubASCII(String s){
        int max = 0;
        int j = 0;
        int start = 0;
        boolean[] exist = new boolean[256];

        for(int i=0;i < s.length();i++){
            while (exist[s.charAt(i)]){
                exist[s.charAt(j)] = false;
                j++;
            }
            exist[s.charAt(i)] = true;
            if(i-j+1 > max){
                max = i-j+1;
                start = j;
            }
        }

        return s.substring(start,start+max);
    }

    public static int LonggestSubUnicodeCount(String s){
        int max = 0;
        int j = 0;

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static int ReverseInt(int input){
        int output = 0;

        while (input != 0){
            if(Math.abs(output) > Integer.MAX_VALUE){
                return 0;
            }
            output = output*10 + input%10;
            input = input / 10;

        }

        return output;
    }

    public static List<Integer> Plusone(List<Integer> nums){

        int index = 0;
        for(int i=nums.size()-1;i>=0;i--){
            int d = nums.get(i);
            if(d<9){
                nums.set(i,d+1);
                return nums;
            }
            nums.set(i,0);
        }
        nums.add(0);
        nums.set(0,1);

        return nums;
    }

    public static boolean isPan(int x){
        if(x<0){
            return false;
        }
        int digits =1;
        int temp = x;
        while (x/10 > 0){
            digits = digits * 10;
            x = x/10;
        }

        while (temp > 0 ){
            if(temp/digits != temp %10){
                return false;
            }
            temp = (temp % digits) /10;
            digits = digits/100;
        }

        return true;

    }

    public static LinkedList<Comparable> Merge(LinkedList<Comparable> la, LinkedList<Comparable> lb){
        //asc
        LinkedList<Comparable> lm = new LinkedList<Comparable>();
        while (!la.isEmpty() || ! la.isEmpty()){
            if(la.isEmpty() && !lb.isEmpty())
            {
                while (!lb.isEmpty()) {
                    lm.add(lb.removeFirst());
                }
            }
            else if(lb.isEmpty() && !la.isEmpty()){
                while (!la.isEmpty()){
                    lm.add(la.removeFirst());
                }
            }
            else {
                if (la.peek().compareTo(lb.peek()) <= 0) {
                    lm.add(la.removeFirst());
                } else {
                    lm.add(lb.removeFirst());
                }
            }
        }

        return lm;

    }

    public static int ClimbStairs(int n){
        int p = 1;
        int q = 2;
        for(int i=3;i<=n;i++){
            int temp = q;
            q = p + q;
            p = temp;
        }

        return q;
    }

    /*
    f(0) = A(0)
    f(1) = max(f(0)+A(1),A(1))
    f(2) = max(f(1)+A(2),A(2))
    f(n) = max(f(n-1)+A(n),A(n))
     */
    public static int MaxSumSubArray(int[] nums){

        return MaxSumRec(nums,nums.length-1);
    }

    private static int MaxSumRec(int[] nums,int index){


            if(index == 0){
                return nums[0];
            }
            int tmp = MaxSumRec(nums,index-1);
            if(nums[index]>0){
                return Math.max(tmp+nums[index],nums[index]);
            }

            return tmp;

    }


    private void test(){
        LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>();
        LinkedList<Integer> ll = new LinkedList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        int[] iArr = new int[200];
        HashSet<Integer> hs = new HashSet<>();

    }
}
