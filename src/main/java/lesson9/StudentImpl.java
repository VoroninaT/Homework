package lesson9;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements Student {

    private final String name;

    private final List<Course> courses = new ArrayList<>();

    public StudentImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }

    public void addAllCourses(List<Course> courses) {
        this.courses.addAll(courses);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
