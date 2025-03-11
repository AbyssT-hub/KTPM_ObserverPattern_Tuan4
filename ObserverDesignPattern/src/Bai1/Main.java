package Bai1;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Student {
    void update(String message);
}

// Concrete Observer
class ConcreteStudent implements Student {
    private String name;

    public ConcreteStudent(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " nhận được thông báo: " + message);
    }
}

// Subject interface
interface ClassRoom {
    void addStudent(Student student);
    void removeStudent(Student student);
    void notifyStudents(String message);
}

// Concrete Subject
class ConcreteClassRoom implements ClassRoom {
    private List<Student> students = new ArrayList<>();
    private String name;

    public ConcreteClassRoom(String name){
        this.name = name;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public void notifyStudents(String message) {
        for (Student student : students) {
            student.update(message);
        }
    }
}

//Example
public class Main {
    public static void main(String[] args) {
        ConcreteClassRoom classA = new ConcreteClassRoom("Lớp A");

        ConcreteStudent student1 = new ConcreteStudent("Nguyễn Văn A");
        ConcreteStudent student2 = new ConcreteStudent("Trần Thị B");
        ConcreteStudent student3 = new ConcreteStudent("Lê C");

        classA.addStudent(student1);
        classA.addStudent(student2);
        classA.addStudent(student3);

        classA.notifyStudents("Thông báo: Buổi học ngày mai nghỉ.");
    }
}