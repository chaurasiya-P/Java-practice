package main.java;

import java.util.*;
import java.util.stream.Collectors;

//https://www.geeksforgeeks.org/problems/nine-divisors3751/1
public class TotalNineDivisor {

    public static void main(String[] args) {
        System.out.println(countNumbers(10));
        //System.out.println(countNumbers(100));
        //System.out.println(countNumbers(196));
    }

    public static int countNumbers(int n) {
        int m = (int)Math.sqrt(n);
        boolean[] b = new boolean[m+1];
        Arrays.fill(b, true);
        for(int i=2;i*i<=m+1; i++) {
            if(b[i]) {
                for(int j=2*i;j<m+1;j+=i) b[j] = false;
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(4);
        for(int i=3;i<=m;i+=2) {
            if(b[i]) l.add(i*i);
        }
        System.out.println(l.size());
        int s=0;
        int r=l.size()-1;
        int ans = 0;
        while(s<r) {
            if(l.get(s) * l.get(r) <= n) {
                ans+=(r-s);
                s++;
            } else {
                r--;
            }
        }
        l.clear();
        if((int)Math.pow(2,8) <= n) ans++;
        if((int)Math.pow(3,8) <= n) ans++;
        if((int)Math.pow(5,8) <= n) ans++;
        if((int)Math.pow(7,8) <= n) ans++;
        if((int)Math.pow(11,8) <= n) ans++;
        return ans;
    }
}
