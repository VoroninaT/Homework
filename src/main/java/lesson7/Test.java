package lesson7;

public class Test {
    public static void main(String[] args) {

        // создаем котов
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Мурзик");
        cats[2] = new Cat("Пушок");
        cats[3] = new Cat("Багира");

        // создаем тарелку
        Plate plate = new Plate(50);

        // кормим котов
        feedCats(cats, plate);

        // узнаем сытость котов
        printCatsReport(cats);

        // добавляем еды в тарелку
        plate.addFood(20);

        // кормим котов еще раз
        feedCats(cats, plate);

        // узнаем сытость котов
        printCatsReport(cats);

    }

    private static void feedCats(Cat[] cats, Plate plate) {
        System.out.println();
        System.out.println("== КОРМЛЕНИЕ НАЧАТО ========================================================================");

        plate.printInfo();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        System.out.println();
        plate.printInfo();
        System.out.println("== КОРМЛЕНИЕ ЗАВЕРШЕНО ===================================================================== ");
    }

    private static void printCatsReport(Cat[] cats) {
        System.out.println();
        System.out.println("Сытость котов: ");
        for (int i = 0; i < cats.length; i++) {
            cats[i].printInfo();
        }
    }
}
