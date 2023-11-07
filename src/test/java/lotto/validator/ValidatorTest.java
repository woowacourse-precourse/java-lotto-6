package lotto.validator;

import static lotto.validator.Error.NOT_NUMERIC_INPUT;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("숫자 입력 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1024"})
    void validateNumeric(String input) {
        assertDoesNotThrow(() -> Validator.validateNumeric(input));
    }

    @DisplayName("숫자 입력 검증_0이상의 숫자만 허용")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "ddf", "1dfae"})
    void validateNumericFail(String input) {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumeric(input));
    }

    @DisplayName("예외 발생시 적절한 메세지 출력")
    @Test
    void validateErrorMessage() {
        Assertions.assertThatThrownBy(() -> Validator.validateNumeric("-12e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMERIC_INPUT.message())
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("당첨 번호 입력 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6","11,12,13,14,15,16"})
    void validateWinningNumbersInput(String input) {
        assertDoesNotThrow(() -> Validator.validateMainNumbersInput(input));
    }

    @DisplayName("당첨 번호 입력 검증_숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,A,3,4,5,6"})
    void validateWinningNumbersInputFail(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validateMainNumbersInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_FORMAT_WINNING_NUMBERS.message());
    }

    @DisplayName("구매 금액 검증")
    @Test
    void validatePayment() {
        assertDoesNotThrow(() -> Validator.validatePayment(3000));
    }

    @DisplayName("구매 금액 검증_0원인 경우")
    @Test
    void validatePayment_notPositive_fail() {
        Assertions.assertThatThrownBy(() -> Validator.validatePayment(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_PAYMENT.message());
    }

    @DisplayName("구매 금액 검증_1000원으로 나누어 떨어지지 않는 경우")
    @Test
    void validatePayment_wrongUnit_fail() {
        Assertions.assertThatThrownBy(() -> Validator.validatePayment(1320))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_PAYMENT.message());
    }

    @DisplayName("당첨 번호 검증")
    @Test
    void winningNumbers() {
        assertDoesNotThrow(() -> Validator.validateMainNumbers(List.of(1, 2, 3, 4, 5, 45)));
    }

    @DisplayName("당첨 번호 검증_6개가 아닌 경우")
    @Test
    void winningNumbers_invalidSize() {
        Assertions.assertThatThrownBy(() -> Validator.validateMainNumbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_NUM_MAIN_NUMBER.message());
    }

    @DisplayName("당첨 번호 검증_범위를 벗어난 경우")
    @Test
    void winningNumbers_invalidRange() {
        Assertions.assertThatThrownBy(() -> Validator.validateMainNumbers(List.of(1, 2, 3, 4, 45, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_RANGE_WINNING_NUMBER.message());
    }

    @DisplayName("당첨 번호 검증_중복 번호")
    @Test
    void winningNumbers_Duplicated() {
        Assertions.assertThatThrownBy(() -> Validator.validateMainNumbers(List.of(1, 2, 3, 4, 45, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.DUPLICATED_MAIN_NUMBER.message());
    }

    //validateBonusNumber
    @DisplayName("보너스 번호 검증")
    @Test
    void bonusNumber() {
        assertDoesNotThrow(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 45));
    }

    @DisplayName("보너스 번호 검증_범위를 벗어난 경우")
    @Test
    void bonusNumber_invalidRange() {
        Assertions.assertThatThrownBy(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_RANGE_WINNING_NUMBER.message());
    }

    @DisplayName("보너스 번호 검증_중복 번호")
    @Test
    void bonusNumber_Duplicated() {
        Assertions.assertThatThrownBy(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.DUPLICATED_BONUS_NUMBER.message());
    }

}