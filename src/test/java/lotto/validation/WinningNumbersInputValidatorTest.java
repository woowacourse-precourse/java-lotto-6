package lotto.validation;

import static lotto.validation.constant.WinningNumbers.CHECK_COMMA_MESSAGE;
import static lotto.validation.constant.WinningNumbers.DUPLICATE_MESSAGE;
import static lotto.validation.constant.WinningNumbers.NUMBERS_COUNT_MESSAGE;
import static lotto.validation.constant.WinningNumbers.NUMBER_RANGE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "-1,2,4,5,6,7", "2,3,5,0,4,6"})
    @DisplayName("입력값의 숫자들이 지정된 범위 안에 존재하지 않으면 예외가 발생하는 테스트")
    void testValidateNumberRange(String input) {
        WinningNumbersInputValidator inputValidation = new WinningNumbersInputValidator();

        assertThatThrownBy(() -> inputValidation.validateNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "", "1 2 3 4 5 6"})
    @DisplayName("입력값의 숫자들이 , 로 구분되어 있지 않으면 예외가 발생하는 테스트")
    void testValidateCommaSeparatedNumbers(String input) {
        WinningNumbersInputValidator inputValidation = new WinningNumbersInputValidator();

        assertThatThrownBy(() -> inputValidation.validateCommaSeparatedNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CHECK_COMMA_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,3,4,6", "2,2,3,4,4,4"})
    @DisplayName("입력값의 숫자들이 중복 되어 있으면 예외가 발생하는 테스트")
    void testValidateNumberDuplication(String input) {
        WinningNumbersInputValidator inputValidation = new WinningNumbersInputValidator();

        assertThatThrownBy(() -> inputValidation.validateNumberDuplication(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "2,3"})
    @DisplayName("입력값의 숫자들이 6개가 아니면 예외가 발생하는 테스트")
    void testValidateNumbersCount(String input) {
        WinningNumbersInputValidator inputValidation = new WinningNumbersInputValidator();

        assertThatThrownBy(() -> inputValidation.validateNumbersCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_COUNT_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,15,27,34,45"})
    @DisplayName("당첨 번호 입력에 대해 모든 검증을 하여 정상 입력이면 예외가 발생하지 않아야 하는 테스트")
    void testValidateWinningNumbers(String input) {
        WinningNumbersInputValidator inputValidation = new WinningNumbersInputValidator();

        assertThatCode(() -> inputValidation.validateWinningNumbers(input))
                .doesNotThrowAnyException();
    }
}