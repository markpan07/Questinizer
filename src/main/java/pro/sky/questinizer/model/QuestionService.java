package pro.sky.questinizer.model;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(String question);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    void clear();

}
