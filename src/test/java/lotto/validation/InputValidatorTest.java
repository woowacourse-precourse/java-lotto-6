package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.EmptyInputException;
import lotto.exception.NegativeOrZeroInputException;
import lotto.exception.NonNumericInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("구매금액에 빈 값을 입력할 경우 예외가 발생한다.")
    @Test
    void validate_buy_amount_empty_input_test() {
        // then
        assertThrows(EmptyInputException.class, () -> {
            InputValidator.validateBuyAmount("");
        });
    }

    @DisplayName("구매금액에 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void validate_buy_amount_non_numeric_input_test() {
        // then
        assertThrows(NonNumericInputException.class, () -> {
            InputValidator.validateBuyAmount("abc");
        });
    }

    @DisplayName("구매금액에 0 또는 음수를 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void validate_buy_amount_negative_input_test(String input) {
        // then
        assertThrows(NegativeOrZeroInputException.class, () -> {
            InputValidator.validateBuyAmount(input);
        });
    }

    @DisplayName("구매금액에 유효 값을 입력 시 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "50000"})
    void validate_buy_amount_positive_input_test(String input) {
        // then
        assertDoesNotThrow(() -> {
            InputValidator.validateBuyAmount(input);
        });
    }

    @DisplayName("당첨번호에 빈 값을 입력할 경우 예외가 발생한다.")
    @Test
    void validate_winning_numbers_empty_input_test() {
        // when
        String input = "";

        // then
        assertThrows(EmptyInputException.class, () -> {
            InputValidator.validateWinningNumbers(input);
        });
    }

    @DisplayName("보너스 번호에 빈 값을 입력할 경우 예외가 발생한다.")
    @Test
    void validate_bonus_number_empty_input_test() {
        // when
        String input = "";

        // then
        assertThrows(EmptyInputException.class, () -> {
            InputValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("보너스 번호에 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void validate_bonus_number_non_numeric_input_test() {
        // when
        String input = "abc";

        // then
        assertThrows(NonNumericInputException.class, () -> {
            InputValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("구매금액에 유효한 값을 입력 시 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void validate_bonus_number_numeric_input_test(String input) {
        // then
        assertDoesNotThrow(() -> {
            InputValidator.validateBonusNumber(input);
        });
    }
}
