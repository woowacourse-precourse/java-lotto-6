package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusTest {

    @DisplayName("보너스 번호가 1~45 사이의 번호가 아닐 경우 예외가 발생한다.")
    @Test
    public void createOutOfRange() {
        assertThatThrownBy(() -> new LottoBonus(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}