package main.java;

import java.util.*;

//https://www.geeksforgeeks.org/problems/power-of-k-in-n-where-k-may-be-non-prime4206/1
public class PowerK {

    public static void main(String[] args) {
        System.out.println(maxKPower(9,14));
        System.out.println(maxKPower(7,2));
        System.out.println(maxKPower(4,8));
    }

    public static int maxKPower(int n, int k) {
        // code here

        Map<Integer, Integer> m = new HashMap<>();
        int kk = k;
        int c=0;
        while(k%2 == 0) {
            c++;
            k=k/2;
        }
        if(c!=0) m.put(2,c);
        for(int i=3;i*i<=k;i+=2) {
            c=0;
            while(k%i == 0) {
                c++;
                k=k/i;
            }
            if(c!=0) m.put(i,c);
        }
        if(k>2) m.put(k,1);
        Map<Integer, Integer> mm = new HashMap<>();
        //List<Integer> dk = m.keySet().stream().sorted().collect(Collectors.toList());
        Set<Integer> ss = m.keySet();
        List<Integer> dk = new ArrayList<>();
        for(Integer i:ss) dk.add(i);
        Collections.sort(dk);
        int ans = Integer.MAX_VALUE;
        for(int i=2;i<=n;i++) {
            int j=i;
            int y = 1;
            for(int x=0;x<dk.size() && j>0 ;x++) {
                //if(j%dk.get(x)!=0) break;
                int cc=0;
                while(j%dk.get(x)==0) {
                    cc++;
                    y=y*dk.get(x);
                    j=j/dk.get(x);
                }
                //if(!mm.containsKey(dk.get(x))) mm.put(dk.get(x),0);
                mm.put(dk.get(x), mm.getOrDefault(dk.get(x),0)+cc);
                //ans+=(y/kk);
            }
        }
        for(Integer i:m.keySet()) {
            if(!mm.containsKey(i)) return 0;
            int xx = mm.get(i);
            int yy = m.get(i);
            ans = Math.min(ans,(xx/yy));
        }
        return ans;
    }
}
