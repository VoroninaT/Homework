package lesson1;

public class Main {
    public  static void main (String[] args) {
        System.out.println("Hello, Word");
        printHelloWord();
        printHelloWord();
        testVars();
        testAppraisal();
    }

    public static void printHelloWord() {
        System.out.println("Hello, word from method!");

    }
    static void testVars() {
        int x;
        x = 9;
        int b = 5;
        long a = 100000000000000000L;
        System.out.println(1.0 * x + b);
        System.out.println(x + (double)b);
        double c = 9; // (double)9
        double y = 9.0;
        float d = 3.9f;
        char ch1 = 1234;
        char ch2 = 'A';
        System.out.println(ch1);
        System.out.println(ch2);

    }
    private static void testAppraisal() {
        int appraisal = 5;
        if (appraisal == 5) {
            System.out.println("Молодец!");

        }

    }

}
