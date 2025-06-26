package main.java;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    private static int c=1;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        subsequenceUtil(list, 0, list.size(), new ArrayList<>());

    }

    private static void subsequenceUtil(List<Integer> list, int start, int end, List<Integer> l) {
        if(start>end) {
            return;
        }
        System.out.println(c+" "+l);
        c++;
        for(int i=start;i<end;i++) {
            l.add(list.get(i));
            subsequenceUtil(list, i+1, end, l);
            l.remove(l.size()-1);
        }
    }
}
