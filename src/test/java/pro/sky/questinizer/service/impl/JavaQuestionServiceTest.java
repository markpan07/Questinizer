package pro.sky.questinizer.service.impl;

import pro.sky.questinizer.exception.QuestionDoesNotExistException;
import pro.sky.questinizer.exception.QuestionListIsEmptyException;
import pro.sky.questinizer.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.questinizer.service.impl.JavaQuestionService;

class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    void setUp() {
        out.add("Question 1", "Answer 1");
        out.add("Question 2", "Answer 2");
        out.add("Question 3", "Answer 3");
    }

    @AfterEach
    void after() {
        out.clear();
    }

    @Test
    void add1() {
        out.add("Question 4", "Answer 4");

        Assertions.assertThat(out.getAll())
                .contains(new Question("Question 4", "Answer 4"));
    }

/*    @Test
    void add2() {
        out.add("Question 4");

        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 1", "Answer 1"),
                        new Question("Question 2", "Answer 2"),
                        new Question("Question 4"));

    }*/

    @Test
    void add3() {
        Question q = new Question("Question 4", "Answer 4");
        out.add(q);

        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 1", "Answer 1"),
                        new Question("Question 2", "Answer 2"),
                        new Question("Question 4", "Answer 4"));
    }

    @Test
    void addAlreadyExist1() {
        out.add("Question 3", "Answer 3");
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 1", "Answer 1"),
                        new Question("Question 2", "Answer 2"));
    }

    @Test
    void addAlreadyExist2() {
        Question q = new Question("Question 3", "Answer 3");
        out.add(q);
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 1", "Answer 1"),
                        new Question("Question 2", "Answer 2"));
    }

/*    @Test
    void addAlreadyExist3() {
        Question q = new Question("Question 3");
        out.add(q);
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 1", "Answer 1"),
                        new Question("Question 2", "Answer 2"));
    }*/

    @Test
    void remove() {
        Question q = new Question("Question 1", "Answer 1");
        Assertions.assertThat(out.remove(q))
                .isEqualTo(q);
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 2", "Answer 2"));
        Assertions.assertThatExceptionOfType(QuestionDoesNotExistException.class)
                .isThrownBy(() -> out.remove("Question 2", "Wrong answer"));
    }

    @Test
    void removeByWords() {
        Assertions.assertThat(out.remove("Question 1", "Answer 1"))
                .isEqualTo(new Question("Question 1", "Answer 1"));
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 2", "Answer 2"));

    }

    @Test
    void removeAbsent() {
        Assertions.assertThatExceptionOfType(QuestionDoesNotExistException.class)
                .isThrownBy(() -> out.remove("Question 5", "Answer 5"));
    }

    @Test
    void getAll() {
        Question q1 = new Question("Question 1", "Answer 1");
        Question q2 = new Question("Question 2", "Answer 2");
        Question q3 = new Question("Question 3", "Answer 3");

        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrder(q1, q2, q3);
    }

    @Test
    void getAllEmpty() {
        out.clear();
        Assertions.assertThatExceptionOfType(QuestionListIsEmptyException.class)
                .isThrownBy(() -> out.getRandomQuestion());
    }

    @Test
    void getRandomQuestion() {
        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(out.getAll())
                    .contains(out.getRandomQuestion());

        }
    }
}