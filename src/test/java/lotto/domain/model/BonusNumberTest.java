package lotto.domain.model;

import lotto.constant.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45의 범위에 속하지 않으면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber(48))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_OUT_OF_RANGES);
    }
}