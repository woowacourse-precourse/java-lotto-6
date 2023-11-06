package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @DisplayName("정수인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "+1", "1", })
    void checkInteger(String number) {
        assertThatCode(() -> inputValidator.checkInteger(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("정수 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1.1", "String", " ", })
    void checkNotInteger(String number) {
        assertThatThrownBy(() -> inputValidator.checkInteger(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 정수를 입력 해야 합니다.");
    }

    @DisplayName("공백 없는 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2", "1,2/3"})
    void checkNotBlank(String number) {
        assertThatCode(() -> inputValidator.checkBlank(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("공백 포함 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", "2  ", "1 ", "1,2, 3", " 1,2", "1,2, "})
    void checkBlankException(String numbers) {
        assertThatThrownBy(() -> inputValidator.checkBlank(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 당첨 번호 입력에 공백은 허용되지 않습니다.");
    }
}
