package lesson6;

public class Cat extends Animal {

    private static final int RUNLIMIT = 200;
    public static int catCount = 0;


    private final String name;

    public Cat(String name) {
        this.name = name;
        catCount = catCount+1;
    }

    @Override
    public void run(int runValue) {
        if (runValue > RUNLIMIT) {
            System.out.println(this.name + " может пробежать максимум " + RUNLIMIT + " м.");
        } else {
            System.out.println(this.name + " пробежал " + runValue + " м.");
        }
    }

    @Override
    public void sail(int sailValue) {
        System.out.println("Барсик не умеет плавать");

    }
}

