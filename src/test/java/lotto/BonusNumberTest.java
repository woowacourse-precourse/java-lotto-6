package lotto;

import static lotto.error.ErrorMessage.NOT_DIGIT_BONUS_NUMBER;
import static lotto.error.ErrorMessage.NOT_IN_BOUND_BONUS_NUMBER;
import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("숫자가 아닌 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_NotDigitNumber() {
        // Given
        String inputBonusNumber = "가";
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIGIT_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("1보다 작은 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_LessThanLowerBound() {
        // Given
        String inputBonusNumber = "0";
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_BOUND_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("45보다 큰 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_GreaterThanUpperBound() {
        // Given
        String inputBonusNumber = "46";
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_BOUND_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 있는 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createBonusNumber_DuplicatedNumber() {
        // Given
        String inputBonusNumber = "3";
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // When & Then
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_UNIQUE_BONUS_NUMBER.getMessage());
    }

}