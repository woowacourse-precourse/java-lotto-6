package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusTest {
    @DisplayName("로또 번호가 1이상 45이하의 수가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        assertThatThrownBy(() -> new LottoBonus(52))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
