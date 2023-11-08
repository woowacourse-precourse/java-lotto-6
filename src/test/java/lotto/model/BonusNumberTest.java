package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("숫자가 아닌 문자열을 보너스 숫자로 입력할 때 예외 발생.")
    @Test
    void createBonusNumberWithLetter() {
        assertThatThrownBy(() -> new BonusNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이가 아닌 숫자를 보너스 숫자로 입력할 때 예외 발생.")
    @Test
    void createBonusNumberOutOfBound() {
        assertThatThrownBy(() -> new BonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
