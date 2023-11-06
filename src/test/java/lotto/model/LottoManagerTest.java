package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
    @Test
    void 로또_구입금액_테스트() {
        assertAll(
                () -> assertDoesNotThrow(() -> new LottoManager(1000)),
                () -> assertDoesNotThrow(() -> new LottoManager(5000)),
                () -> assertThatThrownBy(() -> new LottoManager(5600))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoManager(500))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 로또_발행_테스트() {
        LottoManager lottoManager = new LottoManager(5000);
        lottoManager.ticket();
        assertEquals(lottoManager.toString()
                .chars()
                .filter(c -> c == '[')
                .count(), 5);
    }

    @Test
    void 정답_로또_보관_테스트() {
        LottoManager lottoManager = new LottoManager(1000);
        Lotto answerLotto = new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertTrue(lottoManager.registerAnswerLotto(answerLotto)),
                () -> assertFalse(lottoManager.registerAnswerLotto(lotto))
        );
    }
}
