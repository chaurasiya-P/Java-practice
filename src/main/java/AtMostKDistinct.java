package main.java;

import java.util.*;
public class AtMostKDistinct {

    public static int countAtMostK(int a[], int k) {
        // code here
        int n=a.length;
        Map<Integer, Integer> m = new HashMap<>();
        int i=0;
        int r=0;
        int c=0;
        for(int j=0;j<n;j++) {
            if(m.containsKey(a[j])) {
                int t = m.get(a[j]);
                m.put(a[j],t+1);
            } else {
                m.put(a[j],1);
                c++;
            }
            while(c>k) {
                int t = m.get(a[i]);
                if(t==1) {
                    m.remove(a[i]);
                    c--;
                } else {
                    m.put(a[i], t-1);
                }

                i++;
            }
            r+=(j-i+1);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        int k = 3;
        System.out.println(countAtMostK(a, k));
    }
}
