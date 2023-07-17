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


//
//  @GetMapping("/search")
//  public String showSearchForm() {
//    System.out.println("qqq");
//    return "search";
//  }
//
//  @PostMapping("/search")
//  public String performSearch(@RequestParam("query") String query, Model model) {
//    // Add your search logic here
//    model.addAttribute("query", DBManager.getStudentBySurname(query));
//    System.out.println("asddsd");
//    System.out.println(DBManager.getStudentBySurname(query)+" ASDASD");
//    System.out.println(DBManager.getStudentBySurname(query));
//    // Pass the search results to the view
//    //model.addAttribute("query", query);
//    // Add the necessary attributes to display the search results
//    return "search";
//  }

  @GetMapping("/search")
  public String search(@RequestParam("keyword") String keyword, Model model) {
    // Здесь можно выполнить логику поиска, например, получить результаты из базы данных
   // List<Student> searchResults = // Ваш код для поиска студентов по ключевому слову
    //List<Student> searchResults =
    System.out.println("llll");
    model.addAttribute("searchResults", DBManager.getStudentByKeyName(keyword));
    System.out.println(DBManager.getStudentByKeyName(keyword));
    return "search_results";
  }


}
