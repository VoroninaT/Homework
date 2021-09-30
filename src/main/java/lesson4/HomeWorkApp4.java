package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {
    public static int SIZE = 5;
    public static int DOTS_FOR_WIN = 4; // для победы нужно поставить подряд 4 фишки


    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static char[][] map;

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {

            humanTurn();
            printMap();

            if (isWinner(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isNoWinner()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (isWinner(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isNoWinner()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    // инициализируем ировое поле и заполняем точками
    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // проверка победы
    public static boolean isWinner(char symb) {

        // проверяем вертикали
        for (int i = 0; i < SIZE; i++) {
            int count = 0;

            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    count++;
                } else {
                    count = 0;
                }
            }

            if (count >= DOTS_FOR_WIN) {
                System.out.println("Победа по вертикали " + (i + 1));
                return true;
            }
        }

        // проверяем горизонтали
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    count++;
                } else {
                    count = 0;
                }
            }
            if (count >= DOTS_FOR_WIN) {
                System.out.println("Победа по горизонтали " + (i + 1));
                return true;
            }
        }

        // проверяем диагональ
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                count++;
            } else {
                count = 0;
            }
        }
        boolean result = (count >= DOTS_FOR_WIN);
        if (result) {
            System.out.println("Победа по диагонали");
        }
        return result;
    }

    public static boolean isNoWinner() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    // ход компьютера
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    // ход игрока
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return true;
        }
        return map[y][x] != DOT_EMPTY;
    }

    // вывод игрового поля на экран
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");      // цифры по горизонтали
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " "); // цифры по вертикали
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " "); // вывод поля
            }
            System.out.println();
        }
        System.out.println();
    }
}

