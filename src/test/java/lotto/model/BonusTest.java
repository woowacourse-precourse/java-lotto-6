package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @DisplayName("보너스 번호에 1~45 숫자 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Bonus(0))
            .isInstanceOf(IllegalArgumentException.class);
    }


}
