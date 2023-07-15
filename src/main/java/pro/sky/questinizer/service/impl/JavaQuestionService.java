package pro.sky.questinizer.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.questinizer.exception.QuestionDoesNotExistException;
import pro.sky.questinizer.exception.QuestionListIsEmptyException;
import pro.sky.questinizer.model.Question;
import pro.sky.questinizer.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();
    Random r = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

/*    @Override
    public Question add(String question) {
        return add(new Question(question));
    }*/

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionDoesNotExistException("Такого вопроса нет в списке");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

/*    @Override
    public Question remove(String question) {
        return remove(new Question(question));

    }*/

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionListIsEmptyException("Список вопросов пуст");
        }
        return new ArrayList<>(questions).get(r.nextInt(questions.size()));
    }

    @Override
    public void clear() {
        questions.clear();
    }

    public Question getQuestion(String question, String answer) {
        Question q = new Question(question, answer);
        if (questions.contains(q)) {
            return q;
        } else {
            throw new QuestionDoesNotExistException("Такого вопроса нет в базе");
        }
    }


}
