package JavaLearning;

import java.util.Objects;

public class Student extends Person{

    int age;
    String name;

    public Student() {
        count++;
        System.out.println("count = " + count);
    }

    // 实现 规范的 细节和步骤
    @Override
    public void sit(int input) {
        System.out.println("Student is sitting...... on " + input);
    }

    @Override
    public void sit2(int input) {
        System.out.println("Student is sitting 2...... on " + input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
