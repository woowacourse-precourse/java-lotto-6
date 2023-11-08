package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호가 유효 범위인 1~45를 벗어나면 예외가 발생한다")
    @Test
    void createBonusNumberOutofRange() {
        //given
        int bonusNumber = 78;

        //when, then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}