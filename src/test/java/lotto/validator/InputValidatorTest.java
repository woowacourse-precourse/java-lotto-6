package lotto.validator;

import lotto.constants.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력 검증 객체에 대해")
class InputValidatorTest {

    private static final String error = ErrorMessage.ERROR_TAG.toString();
    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"박준수", "pobi", "!@#"})
    @DisplayName("숫자로 입력을 하지 않으면 에러가 발생한다.")
    void When_InputNotNumeric_Then_Error(String number) {
        assertThatThrownBy(() -> inputValidator.validateNumeric(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12", "1"})
    @DisplayName("숫자로 입력하면 정상적이다.")
    void When_InputNumeric_Then_Correct(String number) {
        assertThatCode(() -> inputValidator.validateNumeric(number))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2/3", "1-2-3", ",,,"})
    @DisplayName("컴마를 기준으로 문자열을 구분한다.")
    void When_InputNotDivisionComma_Then_Error(String winningNumber) {
        assertThatThrownBy(() -> inputValidator.validateDivisionComma(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4", "1,2,3,4,5"})
    @DisplayName("컴마를 기준으로 입력하면 정상적이다.")
    void When_InputDivisionComma_Then_Correct(String winningNumber) {
        assertThatCode(() -> inputValidator.validateDivisionComma(winningNumber))
                .doesNotThrowAnyException();
    }


}
