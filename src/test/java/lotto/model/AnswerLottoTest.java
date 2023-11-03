package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnswerLottoTest {
    private static List<Integer> numbers;

    @BeforeAll
    static void beforeAll() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨_번호_여부_테스트() {
        Lotto lotto = new Lotto(numbers);
        Lotto answerLotto = new AnswerLotto(numbers, 7);
        assertAll(
                () -> assertFalse(lotto.isAnswerLotto()),
                () -> assertTrue(answerLotto.isAnswerLotto())
        );
    }

    @Test
    void 보너스_번호_테스트() {
        assertAll(
                () -> assertThatThrownBy(() -> new AnswerLotto(numbers, 0))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new AnswerLotto(numbers, 1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
