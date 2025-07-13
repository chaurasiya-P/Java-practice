package main.java;

//https://leetcode.com/problems/most-profit-assigning-work/description/
public class MostProfitAssignWork {

    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDiff = 0;
        for(int t:difficulty) maxDiff = Math.max(maxDiff, t);
        int[] mxDiff = new int[maxDiff+1];
        for(int i=0;i<difficulty.length;i++) mxDiff[difficulty[i]] = Math.max(mxDiff[difficulty[i]], profit[i]);
        for(int i=1;i<=maxDiff;i++) {
            mxDiff[i] = Math.max(mxDiff[i], mxDiff[i-1]);
        }
        int result = 0;
        for(int t:worker) {
            if(t>=maxDiff) result +=mxDiff[maxDiff];
            else result+=mxDiff[t];
        }
        return result;
    }
}
