package lesson6;

public abstract class Animal {
    public static int animalCount = 0;

    public Animal() {
        animalCount = animalCount + 1;
    }

    public abstract void run(int runValue);

    public abstract void sail(int sailValue);
}

