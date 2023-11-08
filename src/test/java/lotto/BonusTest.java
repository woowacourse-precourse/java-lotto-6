package lotto;

import lotto.entity.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        assertThatThrownBy(() -> new Bonus(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}