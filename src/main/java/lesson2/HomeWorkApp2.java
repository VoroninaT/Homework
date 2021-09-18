package lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {

        // task 1
        boolean sumBetween = test1(5, 9);
        System.out.println(sumBetween);

        // task 2
        test2(10);

        // task 3
        boolean negativeNumber = test3(-3);
        System.out.println(negativeNumber);

        // task 4
        test4("Привет", 3);

        // task 5
        int year = 2020;
        boolean leapYear = test5(year);
        System.out.println("Год " + year + " високосный: " + leapYear);

    }

    static boolean test1(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    static void test2(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

    static boolean test3(int a) {
        return a < 0;
    }

    static void test4(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    static boolean test5(int year) {
        return year % 4 == 0 && ((year % 100 != 0) || year % 400 == 0);
    }
}