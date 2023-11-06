package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @DisplayName("구입 금액이 1,000원보다 적으면 예외가 발생한다")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> LottoGenerator.from(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}