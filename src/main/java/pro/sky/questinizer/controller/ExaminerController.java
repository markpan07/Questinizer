package pro.sky.questinizer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.questinizer.model.Question;
import pro.sky.questinizer.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExaminerController {

    final private ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
