package main.java;

import java.util.*;

public class CountElements {

    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        Arrays.sort(b);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<a.length;i++) {
            if(b[0]>a[i]) {
                res.add(0);
            } else if(b[b.length-1]<=a[i]) {
                res.add(b.length);
            } else {
                int rr=0;
                int l=1;
                int r=b.length-2;
                while(l<=r) {
                    int m = l+(r-l)/2;
                    System.out.println(m + " "+ b[m] + " " + a[i]);
                    if(b[m]<=a[i]) {
                        rr=m;
                        l=m+1;
                    } else {
                        r=m-1;
                    }
                }
                res.add(rr+1);
            }
        }
        return res;
    }

    public static void main (String[] args) {
        int[] a = {1,2,3,4,7,9};
        int[] b = {0,1,2,1,1,4};
        System.out.println(countLessEq(a,b));

    }
}
