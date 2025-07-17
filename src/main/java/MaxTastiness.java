package main.java;

import java.util.Arrays;

public class MaxTastiness {

    public static void main(String[] args) {
        int[] p = {106,195,138,127,79,119,46,198,166,10,41,151,68,198,126,46,140,35,127};
        int k = 12;
        System.out.println(maximumTastiness(p, k));
    }

    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 1;
        int r = price[price.length-1];
        int ans = 0;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isKFit(price, m, k)) {
                ans = m;
                l = m+1;
            } else r = m-1;
        }
        return ans;
    }

    public static boolean isKFit(int[] a, int m, int k) {
        int c = 0;
        int s = a[0];
        int i = 0;
        while(i<a.length) {
            int j = i;
            c++;
            while(j < a.length && a[j]-a[i] < m) {
                j++;
            }
            i = j;
        }
        return c>=k;
    }
}
