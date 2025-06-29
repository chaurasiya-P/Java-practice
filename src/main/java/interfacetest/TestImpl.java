package main.java.interfacetest;

public class TestImpl implements Itest1, Itest2{

    //if both interface have same method signature, then it will not give error. we just need to
    //define method in parent class once
    @Override
    public int sum(int[] a) {
        int s=0;
        for(int t:a) s+=t;
        return s;
    }


    //if both interface have same default method, then it is compilation error. we need to override
    //that method and give definition to it of own once
    @Override
    public int squareSum(int[] a) {
        return Itest2.super.squareSum(a);
    }

    public static void main(String[] args) {
        TestImpl impl = new TestImpl();
        int s = impl.sum(new int[]{1, 2, 3,});
        System.out.println(s);
        int ss = impl.squareSum(new int[] {1,2,3,4});
        System.out.println(ss);

        Itest2 itest2 = new Itest2() {
            @Override
            public int sum(int[] a) {
                int s=0;
                for(int t:a) {
                    s+=(Math.abs(t));
                }
                return s;
            }
        };
        System.out.println(itest2.sum(new int[] {-1, 2,3,-4}));
    }
}
