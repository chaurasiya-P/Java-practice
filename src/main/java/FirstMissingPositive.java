package main.java;

public class FirstMissingPositive {

    public static int missingNumber(int[] a) {
        // code here
        int n=a.length;
        boolean b=false;
        for(int i=0;i<n;i++) {
            if(a[i] == 1) {
                b=true;
                break;
            }
        }
        if(!b) return 1;
        for(int i=0;i<n;i++) {
            if(a[i]<=0) a[i]=1;
            if(a[i]>n) a[i]=1;
        }
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        for(int i=0;i<n;i++) {
            if(a[(a[i]-1)%n] <=n) a[(a[i]-1)%n]+=n;
        }
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        for(int i=0;i<n;i++) {
            if(a[i]<=n) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] a = {1,656868};
        System.out.println(missingNumber(a));
    }
}