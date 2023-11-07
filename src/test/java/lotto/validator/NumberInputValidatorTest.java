package lotto.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberInputValidatorTest {

    @Test
    @DisplayName("유효한 로또 번호가 입력되면 예외가 발생하지 않아야 함")
    void validateWithValidInput() {
        NumberInputValidator validator = new NumberInputValidator();
        String validInput = "5";
        assertThatCode(() -> validator.validate(validInput)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닌 경우 예외가 발생해야 함")
    void validateWithInvalidNumberRange() {
        NumberInputValidator validator = new NumberInputValidator();
        String invalidInput = "50";
        assertThatThrownBy(() -> validator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자로 입력해주세요.");
    }

    @Test
    @DisplayName("로또 번호에 유효하지 않은 숫자가 입력되면 예외가 발생해야 함")
    void validateWithInvalidNumber() {
        NumberInputValidator validator = new NumberInputValidator();
        String invalidInput = "abc";
        assertThatThrownBy(() -> validator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자로 입력하시길 바랍니다.");
    }

}
