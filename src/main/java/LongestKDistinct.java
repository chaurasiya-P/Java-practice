package main.java;

import java.util.*;

public class LongestKDistinct {

    public static int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        Map<Character, Integer> m = new HashMap<>();
        int i=0;
        int r=0;
        int c=0;
        for(int j=0;j<n;j++) {
            if(m.containsKey(s.charAt(j))) {
                int t = m.get(s.charAt(j));
                m.put(s.charAt(j),t+1);
            } else {
                m.put(s.charAt(j),1);
                c++;
            }
            if(c==k) {
                //System.out.println(j);
                r=Math.max(r,j-i+1);
            }
            else if(c>k){
                while(c>k) {
                    int t = m.get(s.charAt(i));
                    if(t==1) {
                        m.remove(s.charAt(i));
                        c--;
                    } else {
                        m.put(s.charAt(i), t-1);
                    }

                    i++;
                }
                //System.out.println(j + " " + i);
                r=Math.max(r,j-i+1);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }
}
