package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Бобик");

        cat1.run(100);
        cat1.sail(1);

        dog1.run(250);
        dog1.sail(50);

        System.out.println("Количество котов: " + Cat.catCount);
        System.out.println("Количество собак: " + Dog.dogCount);
        System.out.println("Количество животных: " + Animal.animalCount);
    }
}