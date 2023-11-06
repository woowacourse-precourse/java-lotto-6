package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
}
