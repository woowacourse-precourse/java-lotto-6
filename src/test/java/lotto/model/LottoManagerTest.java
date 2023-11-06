package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
