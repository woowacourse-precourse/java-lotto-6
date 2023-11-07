package lotto;

import static lotto.error.ErrorMessage.NOT_DIGIT_BONUS_NUMBER;
import static lotto.error.ErrorMessage.NOT_IN_BOUND_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("숫자가 아닌 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_NotDigitNumber() {
        // Given
        String inputBonusNumber = "가";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIGIT_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("1보다 작은 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_LessThanLowerBound() {
        // Given
        String inputBonusNumber = "0";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_BOUND_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("45보다 큰 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_GreaterThanUpperBound() {
        // Given
        String inputBonusNumber = "46";

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_BOUND_BONUS_NUMBER.getMessage());
    }

}