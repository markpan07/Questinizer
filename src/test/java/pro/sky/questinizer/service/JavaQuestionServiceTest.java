package pro.sky.questinizer.service;

import pro.sky.questinizer.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.questinizer.service.JavaQuestionService;

class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    void setUp() {
        out.add("Question 1", "Answer 1");
        out.add("Question 2", "Answer 2");
        out.add("Question 3", "Answer 3");
    }

    @AfterEach
    void after(){
        out.clear();
    }

    @Test
    void add() {
        out.add("Question 4", "Answer 4");
        out.add("Question 5");

        Assertions.assertThat(out.getAll())
                .contains(new Question("Question 4", "Answer 4"), new Question("Question 5"));
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
        Question q = new Question("Question 1", "Answer 1");
        Assertions.assertThat(out.remove(q))
                        .isEqualTo(q);
        Assertions.assertThat(out.getAll())
                .containsExactlyInAnyOrder(
                        new Question("Question 3", "Answer 3"),
                        new Question("Question 2", "Answer 2"));
    }

    @Test
    void getAll() {
        Question q1 = new Question("Question 1", "Answer 1");
        Question q2 = new Question("Question 2", "Answer 2");
        Question q3 = new Question("Question 3", "Answer 3");

        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrder(q1, q2, q3);
    }

    @Test
    void getRandomQuestion() {
        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(out.getAll())
                    .contains(out.getRandomQuestion());

        }
    }
}