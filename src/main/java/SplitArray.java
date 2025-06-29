package main.java;


//https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1
public class SplitArray {
    
    private static boolean fun(int[] a, int k, int m) {
        int s=0;
        int c=0;
        int i=0;
        int j=0;
        while(i<a.length) {
            j=i;
            s=0;
            System.out.println(j);
            while(j<a.length) {
                s+=a[j];
                if(a[j]>m) return false;
                if(s>m) break;
                j++;
            }
            System.out.println(i+" "+j);
            i=j;
            c++;
        }
        return c<=k;
    }
    private static int splitArray(int[] a, int k) {
        // code here
        int c=0,l=1,r=0;
        for(int t:a) r+=t;
        while(l<=r) {
            int m = l+(r-l)/2;
            System.out.println(l + " " + r + " " + m);
            if(fun(a,k,m)) {
                c=m;
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {12,12,12,19,7,6,8,9,19,1};
        int k = 5;
        System.out.println("ans: " + splitArray(a, k));
    }
}
