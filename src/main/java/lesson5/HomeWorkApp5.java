package lesson5;

public class HomeWorkApp5 {
    String name;
    String position;
    String email;
    String phone_number;
    int salary;
    int age;

    public HomeWorkApp5(String name, String position, String email, String phone_number, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                name, position, email, phone_number, salary, age);
    }

    public void print() {
        System.out.println(this);
    }


    public static void main(String[] args) {

        HomeWorkApp5[] persArray = new HomeWorkApp5[5];
        persArray[0] = new HomeWorkApp5("Иван Сидоров", "Директор", "ivan@mail.ru", "+71235678939", 300000, 45);
        persArray[1] = new HomeWorkApp5("Александр Первый", "Инженер", "alex@mail.ru", "+71236548790", 150000, 37);
        persArray[2] = new HomeWorkApp5("Екатерина Воронцова", "Дизайнер", "voron@gmail.ru", "+71231234576", 120000, 41);
        persArray[3] = new HomeWorkApp5("Алексей Самохин", "Программист", "sum@google.com", "+71234765899", 140000, 28);
        persArray[4] = new HomeWorkApp5("Светлана Батькова", "Тестировщик", "baty@yandex.com", "+71238764544", 110000, 25);


        for (HomeWorkApp5 homeWorkApp5 : persArray) {
            if (homeWorkApp5.age > 40) {
                homeWorkApp5.print();
            }
        }

    }
}