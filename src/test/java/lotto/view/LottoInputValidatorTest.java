package lotto.view;

import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoInputValidatorTest {

    @DisplayName("문자열이 숫자로만 이루어지지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"11x", "c345", "abc", "", "123ㅎ4"})
    void validateNumericByString(String input) {
        Assertions.assertThatThrownBy(() -> LottoInputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMERIC.getDesc());
    }

    @DisplayName("문자열이 숫자와 쉼표 구분자로 조합으로 이루어지지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,", "1,2c,3", "1,,3,2", "", ",1,2,3", "13, ", })
    void validateNumericAndCommaByString(String input) {
        Assertions.assertThatThrownBy(() -> LottoInputValidator.validateNumericCommaUnion(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_COMMA.getDesc());
    }

}