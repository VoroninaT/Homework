package lesson6;

public class Dog extends Animal {
    private static final int RUNLIMIT = 500;
    private static final int SAILLIMIT = 10;
    public static int dogCount = 0;

    private final String name;

    public Dog(String name) {
        this.name = name;
        dogCount = dogCount+1;

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
        if (sailValue > SAILLIMIT) {
            System.out.println(this.name + " может проплыть максимум " + SAILLIMIT + " м.");
        } else
            System.out.println(this.name + " проплыл " + sailValue + " м.");

    }
}
