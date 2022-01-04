package lesson9;

public class CourseImpl implements Course {

    private final String name;

    public CourseImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // для поиска уникальных курсов используется HashSet, поэтому надо переопределить equals и hashCode
    // сгенерировала через Intellij IDEA

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseImpl course = (CourseImpl) o;

        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
