package lotto.utils;

import static lotto.enums.ExceptionMessageType.DUPLICATE_BONUS_NUMBER;
import static lotto.enums.ExceptionMessageType.DUPLICATE_WINNING_NUMBERS;
import static lotto.enums.ExceptionMessageType.INVALID_SEPARATOR_OR_NUMBER_COUNT;
import static lotto.enums.ExceptionMessageType.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @DisplayName("쉼표(,)로 구분된 6개 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2abc,3,4,5,6", "1,2,,3,4,5", "1,2,3", "1,2,3,4,5,6,7"})
    void testValidateSeparator(String numbers) {
        assertThatThrownBy(() -> LottoNumbersValidator.validateSeparator(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SEPARATOR_OR_NUMBER_COUNT.getMessage());
    }

    @DisplayName("번호는 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -20})
    void testValidateRange(int numbers) {
        assertThatThrownBy(() -> LottoNumbersValidator.validateRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> LottoNumbersValidator.validateDuplicateNumbers(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateDuplicateNumbers() {
        assertThatThrownBy(() -> LottoNumbersValidator.validateDuplicateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}