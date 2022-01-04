package lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println();

        // список студентов
        List<Student> students = new ArrayList<>();
        students.add(createStudent("Иванов", "курс1", "курс2", "курс3", "курс4", "курс5"));
        students.add(createStudent("Петров", "курс1", "курс2", "курс3", "курс4"));
        students.add(createStudent("Сидоров", "курс1", "курс2", "курс4"));
        students.add(createStudent("Васильев", "курс1", "курс3"));
        students.add(createStudent("Смирнов", "курс1", "курс6"));
        students.add(createStudent("Михайлов", "курс6", "курс7"));
        System.out.println("Студенты: ");
        printStudents(students);
        System.out.println();

        Set<Course> uniqCourses = getUniqCourses(students);
        System.out.println("Уникальные курсы студентов: " + uniqCourses);

        List<Student> threeInquisitive = getTopThreeInquisitive(students);
        System.out.println("Трое самых любознательных: " + threeInquisitive);

        CourseImpl courseForSearch = new CourseImpl("курс3");
        List<Student> studentsOnCourse = getStudentsOnCourse(students, courseForSearch);
        System.out.println("Студенты на курсе '" + courseForSearch + "': " + studentsOnCourse);

    }


    // Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
    // на которые подписаны студенты
    private static Set<Course> getUniqCourses(List<Student> students) {
        Set<Course> uniqCourses = new HashSet<>();

        students.forEach(student -> {
            uniqCourses.addAll(student.getAllCourses());
        });

        return uniqCourses;
    }

    // Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
    // (любознательность определяется количеством курсов)
    private static List<Student> getTopThreeInquisitive(List<Student> students) {
        return students.stream()
                .sorted((student1, student2) -> {
                    int size1 = student1.getAllCourses().size();
                    int size2 = student2.getAllCourses().size();
                    return Integer.compare(size2, size1);
                })
                // можно и через Comparator.comparing но надо приводить тип для reversed сортировки (ненаглядно)
                // .sorted(Comparator.comparing((Student o) -> o.getAllCourses().size()).reversed())
                .limit(3L)
                .collect(Collectors.toList());
    }

    // Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
    // которые посещают этот курс
    private static List<Student> getStudentsOnCourse(List<Student> students, CourseImpl courseForSearch) {

        return students.stream()
                .filter(student -> student.getAllCourses().contains(courseForSearch))
                .collect(Collectors.toList());
    }

    // создаю студента сразу с курсами внутри
    private static StudentImpl createStudent(String name, String... courseNames) {

        StudentImpl student = new StudentImpl(name);

        List<Course> courses = Arrays.stream(courseNames)
                .map(CourseImpl::new)
                .collect(Collectors.toList());

        student.addAllCourses(courses);
        return student;
    }

    private static void printStudents(List<Student> students) {
        students.forEach(student -> {
            System.out.println(student.getName() + " " + student.getAllCourses());
        });
    }
}
