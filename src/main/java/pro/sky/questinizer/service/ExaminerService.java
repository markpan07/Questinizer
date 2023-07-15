package pro.sky.questinizer.service;

import pro.sky.questinizer.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
