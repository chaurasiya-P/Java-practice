package main.java;

//https://www.geeksforgeeks.org/problems/maximum-sum-of-elements-not-part-of-lis/1
public class MaxSumNoLIS {

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        System.out.println(nonLisMaxSum(a));
    }
    public static int nonLisMaxSum(int[] a) {
        // code here
        int n = a.length;
        Pair[] r = new Pair[n];
        int res = 1;
        int sum = a[0];
        int result = Integer.MAX_VALUE;
        r[0] = new Pair(1,a[0]);
        for(int i=1;i<n;i++) {
            r[i] = new Pair(1,a[i]);
            sum+=a[i];
            for(int j=0;j<i;j++) {
                if(r[i].x < r[j].x + 1 && a[i] > a[j]) {
                    r[i].x = r[j].x + 1;
                    r[i].y = r[j].y + a[i];
                    res = Math.max(res,r[i].x);
                } else if(r[i].x == r[j].x + 1 && a[i] > a[j] && r[i].y > r[j].y + a[i]) {
                    r[i].y = r[j].y + a[i];
                }
            }
            System.out.println(i + " " + r[i].x + " " + r[i].y + " " + res);
        }
        for(int i=0;i<n;i++) {
            if(r[i].x == res) {
                result = Math.min(r[i].y, result);
            }
        }

        return sum-result;
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
