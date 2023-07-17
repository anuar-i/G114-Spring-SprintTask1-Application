package kz.springboot.g114.g114springsprintTask1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
  private Long id;
  private String name;
  private String surname;
  private int exam;
  private String mark;

  public void calculateMark() {
    if (exam >= 90) {
      mark = "A";
    } else if (exam >= 75) {
      mark = "B";
    } else if (exam >= 60) {
      mark = "C";
    } else if (exam >= 50) {
      mark = "D";
    } else {
      mark = "F";
    }
  }

}
