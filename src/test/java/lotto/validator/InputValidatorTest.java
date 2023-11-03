package lotto.validator;

import lotto.constants.ErrorMessage;
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
    void When_Input_Not_Numeric_Then_Error(String number) {
        assertThatThrownBy(() -> inputValidator.validateNumeric(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12", "1"})
    @DisplayName("숫자로 입력하면 정상적이다.")
    void When_InputNumeric_Then_Error(String number) {
        assertThatCode(() -> inputValidator.validateNumeric(number))
                .doesNotThrowAnyException();
    }

}
