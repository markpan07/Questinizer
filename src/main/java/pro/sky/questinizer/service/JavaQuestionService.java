package pro.sky.questinizer.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pro.sky.questinizer.exception.QuestionDoesNotExistException;
import pro.sky.questinizer.model.Question;
import pro.sky.questinizer.model.QuestionService;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();
    Random r = new Random();

    @Override
    public Question add(String question, String answer) {
        Question result = new Question(question, answer);
        questions.add(result);
        return result;
    }

    @Override
    public Question add(String question) {
        Question result = new Question(question);
        questions.add(result);
        return result;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question q = getQuestion(question, answer);
        questions.remove(q);
        return q;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int bound = questions.size();
        int number = r.nextInt(bound);
        List<Question> list = new ArrayList<>();
        list.addAll(questions);

        return list.get(number);
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
