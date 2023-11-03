package lotto.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AnswerLottoTest {
    @Test
    void 당첨_번호_여부_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Lotto answerLotto = new AnswerLotto(numbers);
        assertAll(
                () -> assertFalse(lotto.isAnswerLotto()),
                () -> assertTrue(answerLotto.isAnswerLotto())
        );
    }
}
