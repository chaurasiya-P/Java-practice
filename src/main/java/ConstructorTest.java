package main.java;

public class ConstructorTest {

    private int a;
    private String b;

    public ConstructorTest() {
        //this.b = b;
    }
    public ConstructorTest(String b) {
        this.b = b;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
