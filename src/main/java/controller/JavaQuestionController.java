package controller;

import model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    JavaQuestionController (JavaQuestionService javaQuestionService){
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать на экзамен";
    }

    @GetMapping("/java")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/java/add")
    public Question add(@RequestParam ("question") String question,
                        @RequestParam (value = "answer", required = false) String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question remove(@RequestParam ("question") String question,
                        @RequestParam (value = "answer", required = false) String answer) {
        return javaQuestionService.remove(question, answer);
    }

}
