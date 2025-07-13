package main.java;

import java.util.*;

//https://leetcode.com/contest/weekly-contest-457/problems/power-grid-maintenance/
public class PowerGridMaintenance {

    public static void main(String[] args) {
        int c=1;
        int[][] co = {};//{{1,2}, {2,3}, {3,4}, {4,5}};
        int[][] q = {{1,1},{2,1},{1,1}};//,{2,2},{1,2}};
        int[] r = processQueries(c,co,q);
        System.out.println(Arrays.toString(r));
    }
    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        ArrayList<Integer>[] l = new ArrayList[c+1];
        for(int i=1;i<=c;i++) l[i] = new ArrayList<>();
        boolean[] vis = new boolean[c+1];
        Map<Integer,Integer> m = new HashMap<>();
        Map<Integer, TreeSet<Integer>> mm = new HashMap<>();
        int cc=0;
        for(int i=0;i<connections.length;i++) {
            l[connections[i][0]].add(connections[i][1]);
            l[connections[i][1]].add(connections[i][0]);
        }
        for(int i=1;i<=c;i++) {
            if(!vis[i]) {
                cc++;
                bfs(vis, l, i, cc, m, mm);
            }
        }
        List<Integer> rr = new ArrayList<>();
        for(int i=0;i<queries.length;i++) {
            if(queries[i][0] == 2) {
                int g = m.get(queries[i][1]);
                mm.get(g).remove(queries[i][1]);
            }
            if(queries[i][0] == 1) {
                int g = m.get(queries[i][1]);
                if(null == mm.get(g) || mm.get(g).size() == 0) {
                    rr.add(-1);
                }
                else if(mm.get(g).contains(queries[i][1])) {
                    rr.add(queries[i][1]);
                } else {
                    rr.add(mm.get(g).first());
                }
                //mm.get(g).remove(queries[i][1]);
            }
        }
        int[] res = new int[rr.size()];
        for(int i=0;i<rr.size();i++) res[i] = rr.get(i);
        return res;
    }

    private static void bfs(boolean[] vis, ArrayList<Integer>[] l, int n, int cc, Map<Integer,Integer> m, Map<Integer, TreeSet<Integer>> mm) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        vis[n] = true;
        while(!q.isEmpty()) {
            int t = q.peek();
            q.poll();
            m.put(t,cc);
            mm.putIfAbsent(cc, new TreeSet<>());
            mm.get(cc).add(t);
            for(int i=0;i<l[t].size();i++) {
                if(!vis[l[t].get(i)]) {
                    vis[l[t].get(i)] = true;
                    q.add(l[t].get(i));
                }
            }
        }
    }
}
