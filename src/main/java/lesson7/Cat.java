package lesson7;

import java.util.Random;

public class Cat {
    private Random random = new Random();

    private final String name;  // имя кота

    private boolean fullness = false; // признак сытости

    public Cat(String name) {
        this.name = name;

    }

    public void eat(Plate plate) {
        System.out.println();

        if (this.fullness) {
            System.out.println(this.name + " сыт");
            return;
        }

        int plateFoodCount = plate.getFoodCount();
        int wantToEat = random.nextInt(15) + 5;
        System.out.println(this.name + " собирается покушать " + wantToEat + " из миски в которой " + plateFoodCount + " еды");

        if (plateFoodCount >= wantToEat) {
            plate.decreaseFood(wantToEat);
            this.fullness = true;
            System.out.println(this.name + " - поел " + wantToEat);

        } else {
            System.out.println(this.name + " - не хватает еды, остался голодный! ");
        }
    }

    public void printInfo() {
        System.out.println("  " + this.name + ": \t" + this.fullness);
    }

}
