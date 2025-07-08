package main.java;
import java.util.*;

//https://www.geeksforgeeks.org/problems/next-greater-element/1
public class NextGreaterElement {

    public static ArrayList<Integer> nextLargerElement(int[] a) {
        // code here
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<a.length;i++) l.add(a[i]);
        for(int i=0;i<a.length;i++) l.add(a[i]);
        Stack<Integer> s = new Stack<>();
        Set<Integer> st = new HashSet<>();
        int c=0;
        for(Integer i: l) {
            if(s.isEmpty() && c<a.length) s.push(c++);
            else if(i <= a[s.peek()%a.length] && c<a.length) s.push(c++);
            else {
                while(!s.isEmpty() && i > l.get(s.peek())) {
                    if(!st.contains(s.peek()%a.length)) {
                        a[s.peek()%a.length] = i;
                        st.add(s.peek()%a.length);
                    }

                    s.pop();
                }
                s.push(c++);
            }
        }
        while(!s.isEmpty()) {
            if(!st.contains(s.peek()%a.length)) {
                a[s.peek()%a.length] = -1;
                st.add(s.peek()%a.length);
            }
            s.pop();
        }
        l.clear();
        for(int i=0;i<a.length;i++) l.add(a[i]);
        return l;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 3 , 1, 1};
        ArrayList<Integer> l = nextLargerElement(a);
        for(Integer i:l) System.out.println(i);
    }
}
