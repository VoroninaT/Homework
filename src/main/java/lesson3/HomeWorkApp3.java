package lesson3;

import java.util.Arrays;

import static java.util.Arrays.fill;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        // task 1
        System.out.println("TASK1");
        int[] data = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(data));

        int[] result = array1(data);
        System.out.println(Arrays.toString(result));

        // task 2
        System.out.println("TASK2");
        int[] data2 = new int[100];
        System.out.println(Arrays.toString(data2));

        int[] result2 = array2(data2);
        System.out.println(Arrays.toString(result2));

        // task 3
        System.out.println("TASK3");
        int[] data3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(data3));

        int[] result3 = array3(data3);
        System.out.println(Arrays.toString(result3));

        // task 4
        System.out.println("TASK4");
        int[][] data4 = new int[5][5];
        printSquareArray(data4);

        int[][] result4 = squareArray(data4);
        printSquareArray(result4);

        // task 5
        System.out.println("TASK5");
        int[] initialValue = new int[5];
        System.out.println(Arrays.toString(initialValue));

        int[] result5 = lenArr(5, 3);
        System.out.println(Arrays.toString(result5));

        // task 6
        System.out.println("TASK6");
        int[] minMax = {1, 5, 10, 3, 25, 0};
        element(minMax);

        // task 7
        System.out.println("TASK7");
        int[] arr7 = new int[]{1, 1, 1, 1, 1, 1, 100, 1, 1, 1};

        boolean result6 = balanceMas(arr7);
        System.out.println("Результат: " + result6);



        // task 8
        System.out.println("TASK8");
        int[] array  = new int[]{1, 2, 3};
        int   offset = 2;

        moveArray(array, offset);
    }

    public static int[] array1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            } else System.out.println("Неверное значение массива");
        }
        return arr;
    }

    public static int[] array2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static int[] array3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }

    public static int[][] squareArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
        }
        return arr;
    }

    private static void printSquareArray(int[][] array) {
        System.out.println("printSquareArray:");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public static int[] lenArr(int len, int initialValue) {
        int[] arr = new int[len];
        fill(arr, initialValue);
        return arr;
    }
    public static void element(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int j : arr) {
            if (min > j) {
                min = j;
            } else if (max < j) {
                max = j;
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
    private static boolean balanceMas(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int sumLeft  = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + array[j];
            }
            for (int k = i; k < array.length; k++) {
                sumRight = sumRight + array[k];
            }
            if (sumLeft == sumRight) {
                System.out.println("Сумма левой части равна сумме правой. Программа завершена.");
                return true;
            }
        }
        return false;
    }

    private static void moveArray(int[] array, int offset) {
        System.out.println("До: " + Arrays.toString(array));
        int lastIndex = array.length - 1;
        if (offset != 0) {
            if (offset < 0) {
                System.out.println("Сдвиг влево: " + offset);
                for (int i = 0; i < (offset * -1); i++) {
                    int first = array[0];
                    if (lastIndex >= 0) System.arraycopy(array, 1, array, 0, lastIndex);
                    array[lastIndex] = first;
                }
            } else {
                System.out.println("Сдвиг вправо: " + offset);
                for (int i = 0; i < offset; i++) {
                    int last = array[lastIndex];
                    System.arraycopy(array, 0, array, 1, lastIndex);
                    array[0] = last;
                }
            }
        }
        System.out.println("После: " + Arrays.toString(array));
    }
}
