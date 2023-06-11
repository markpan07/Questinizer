package pro.sky.questinizer.controller;

import pro.sky.questinizer.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.questinizer.service.impl.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final JavaQuestionService questionService;

    JavaQuestionController (JavaQuestionService a){
        this.questionService = a;
    }

/*    @GetMapping()
    public String greetings() {
        return "Добро пожаловать на экзамен";
    }*/

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question,
                        @RequestParam String answer) {
        return questionService.remove(question, answer);
    }

}
