package pro.sky.questinizer.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.questinizer.exception.IncorrectAmountOfQuestionException;
import pro.sky.questinizer.model.Question;
import pro.sky.questinizer.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Collection<Question> questions = Set.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4")
    );

    @Test
    void getQuestionsNegative() {
        Mockito.when(questionService.getAll()).thenReturn(questions);

        Assertions.assertThatExceptionOfType(IncorrectAmountOfQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestions(7));
    }

    @Test
    void getQuestions() {
        Mockito.when(questionService.getAll()).thenReturn(questions);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(
                new Question("q1", "a1"),
                new Question("q1", "a1"),
                new Question("q3", "a3"),
                new Question("q2", "a2")
        );

        Assertions.assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("q1", "a1"),
                        new Question("q3", "a3"),
                        new Question("q2", "a2")
                );

    }
}