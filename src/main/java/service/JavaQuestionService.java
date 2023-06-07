package service;

import model.Question;
import model.QuestionService;

import java.util.*;

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
}
