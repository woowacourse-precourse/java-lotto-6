package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_BONUS_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    @Test
    @DisplayName("보너스 번호가 범위 내의 값이 아니라면 예외가 발생한다.")
    void validBonusNumberInRange() {
        // given
        Integer bonusNumber = 50;

        // when & then
        assertThatThrownBy(() -> BonusNumberValidator.validBonusNumberInRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BONUS_NUMBER_OUT_OF_RANGE);
    }
}
