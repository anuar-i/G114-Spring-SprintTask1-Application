package kz.springboot.g114.g114springsprintTask1.db;

import java.util.ArrayList;
import java.util.List;
import kz.springboot.g114.g114springsprintTask1.models.Student;
import lombok.Getter;

public class DBManager {

  @Getter
  private static List<Student> students = new ArrayList<>();

  private static Long id = 11L;

  static {
    students.add(buildStudent(1L, "Nathalia", "Mayer", 89, "B"));
    students.add(buildStudent(2L, "Gia", "Acosta", 100, "A"));
    students.add(buildStudent(3L, "Dakota", "Levy", 73, "C"));
    students.add(buildStudent(4L, "Brynleigh", "Torres", 66, "C"));
    students.add(buildStudent(5L, "Yahir", "Compton", 51, "C"));
    students.add(buildStudent(6L, "Elina", "Conrad", 45, "F"));
    students.add(buildStudent(7L, "Lina", "McLaughlin", 32, "F"));
    students.add(buildStudent(8L, "Reese", "Ayers", 87, "B"));
    students.add(buildStudent(9L, "Isabelle", "Flynn", 2, "F"));
    students.add(buildStudent(10L, "Alyssa", "Berger", 29, "F"));
  }

  private static Student buildStudent(Long id, String name, String surname, int exam, String mark) {
    return Student.builder()
        .id(id)
        .name(name)
        .surname(surname)
        .exam(exam)
        .mark(mark)
        .build();
  }

  public static void addStudent(Student student) {
    student.setId(id);
    id++;
    students.add(student);
  }


  //  var result = items.stream().filter(item -> item.getName().contains(search) ||
//          item.getDescription().contains(search))
//      .map(Item::getName)
//      .collect(Collectors.joining(" / "));
  public static List<Student> getStudentByKeyName(String keyword) {
//    List<Student> list = new ArrayList<>();
//    for (Student student1 : students) {
//      if (student1.getName().contains(keyword) ||
//          student1.getSurname().contains(keyword)) {
//        //String name = student1.getName();
//        list.add(student1);
//      }
//    }

    var result = students.stream().filter(student -> student.getName().contains(keyword) ||
            student.getSurname().contains(keyword))
        .toList();
//      .collect(Collectors.joining(" / "));

//    Student findSt = students.stream().filter(student -> Objects.equals(student.getSurname(), keyword))
//        .findFirst()
//        .orElse(null);
//
//    if(findSt == null){
//      findSt = students.stream().filter(student -> Objects.equals(student.getName(), keyword))
//          .findFirst()
//          .orElse(null);
//    }
//    System.out.println(list);
    return result;
  }
}
