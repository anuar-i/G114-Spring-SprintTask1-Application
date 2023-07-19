package kz.springboot.g114.g114springsprintTask1.controllers;

import kz.springboot.g114.g114springsprintTask1.db.DBManager;
import kz.springboot.g114.g114springsprintTask1.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("studenty", DBManager.getStudents());
    return "home";
  }

  @GetMapping("/add-student")
  public String showAddStudentForm(Model model) {
    model.addAttribute("student", new Student());
    return "add-student";
  }

  @PostMapping("/add-student")
  public String addStudent(@ModelAttribute("student") Student student) {
    student.calculateMark();
    DBManager.addStudent(student);
    return "redirect:/";
  }


  @GetMapping("/search")
  public String search(@RequestParam("keyword") String keyword, Model model) {
    model.addAttribute("searchResults", DBManager.getStudentByKeyName(keyword));
    System.out.println(DBManager.getStudentByKeyName(keyword).size());
    return "search_results";
  }
}