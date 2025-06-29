package main.java.interfacetest;

public interface Itest1 {

   int sum(int[] a);

   default int squareSum(int[] a) {
      int s=0;
      for(int t:a) s+=(t*t);
      return s;
   }
}
