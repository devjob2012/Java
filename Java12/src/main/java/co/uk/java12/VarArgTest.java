package co.uk.java12;

public class VarArgTest {
    public static void main(String[] args) {
        VarArgTest test = new VarArgTest();
        System.out.println(test.test(1));
    }

    public int test(int p, int... str) {
        return p;
    }
}
