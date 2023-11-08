package lotto.domain;

import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("입력된 보너스 넘버가 범위를 넘어갈 때 예외 발생")
    @Test
    void createOutOfRangeBonusNumber(){
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
    }
}