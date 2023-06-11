package pro.sky.questinizer.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.questinizer.exception.IncorrectAmountOfQuestionException;
import pro.sky.questinizer.model.Question;
import pro.sky.questinizer.service.ExaminerService;
import pro.sky.questinizer.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectAmountOfQuestionException("В списке нет столько вопросов");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}
