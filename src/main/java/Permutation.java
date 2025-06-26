package main.java;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    static int c=1;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        permutationUtil(list, 0, list.size());

    }

    private static void permutationUtil(List<Integer> list, int start, int end) {
        if(start==list.size()) {
            System.out.println(c+" "+list);
            c++;
            return;
        }

        for(int i=start;i<end;i++) {
            int t = list.get(i);
            list.set(i, list.get(start));
            list.set(start, t);

            permutationUtil(list, start+1, end);

            t = list.get(i);
            list.set(i, list.get(start));
            list.set(start, t);
        }
    }
}
