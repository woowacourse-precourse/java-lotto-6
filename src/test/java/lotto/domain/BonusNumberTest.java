package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("입력한 보너스 번호의 값이 45 초과이면 예외가 발생한다.")
    @Test
    void inputBonusNumberByOverValue() {
        assertThatThrownBy(() -> new BonusNumber(77))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_MAX_RANGE.getMessage());
    }

    @DisplayName("입력한 보너스 번호의 값이 1 미만이면 예외가 발생한다.")
    @Test
    void inputBonusNumberByUnderValue() {
        assertThatThrownBy(() -> new BonusNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_MIN_RANGE.getMessage());
    }
}