package lotto.validation;

import static lotto.validation.enumType.WinningNumbers.NUMBER_RANGE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "-1,2,4,5,6,7", "2,3,5,0,4,6"})
    @DisplayName("입력값의 숫자들이 지정된 범위 안에 존재하지 않으면 예외가 발생하는 테스트")
    void testValidateNumberRange(String input) {
        WinningNumbersValidator inputValidation = new WinningNumbersValidator();

        assertThatThrownBy(() -> inputValidation.validateNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_MESSAGE.getMessage());
    }
}