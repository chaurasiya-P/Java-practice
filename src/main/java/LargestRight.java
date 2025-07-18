package main.java;

import java.util.*;
public class LargestRight {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,9,5,4,6};
        System.out.println(getRightLargest(a));   //nlogn approach
        System.out.println(getRightLargestn(a));   //n approach

    }

    public static List<Integer> getRightLargest(int[] a) {
        int[] ans = new int[a.length];
        List<Integer> r = new ArrayList<>();
        TreeSet<Integer> t = new TreeSet<>();
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=a.length-1;i>=0;i--) {
            if(i==a.length-1) {
                m.put(i,-1);
                t.add(a[i]);
            }else {
                Integer tt = t.last();
                if(tt > a[i]) m.put(i,tt);
                else m.put(i,-1);
                t.add(a[i]);
            }
        }
        for(Integer i:m.keySet()) {
            ans[i] = m.get(i);
        }
        for(int i:ans) r.add(i);
        //return Arrays.asList(ans);
        return r;
    }

    public static List<Integer> getRightLargestn(int[] a) {
        int[] ans = new int[a.length];
        List<Integer> r = new ArrayList<>();
        int c=a[a.length-1];
        ans[a.length-1] = -1;
        for(int i=a.length-2;i>=0;i--) {
            if(c>a[i]) ans[i] = c;
            else ans[i] = -1;
            c=Math.max(c,a[i]);
        }
        for(int i:ans) r.add(i);
        return r;
    }
}
