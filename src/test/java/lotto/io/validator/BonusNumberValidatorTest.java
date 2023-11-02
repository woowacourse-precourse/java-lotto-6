package lotto.io.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_BE_NUMERIC;
import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberValidatorTest {
    @Test
    @DisplayName("보너스 번호에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> BonusNumberValidator.validate("7 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다")
    void throwExceptionByInputIsNotNumeric() {
        assertThatThrownBy(() -> BonusNumberValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_BE_NUMERIC.message);
    }

    @Test
    @DisplayName("보너스 번호 검증에 성공한다")
    void success() {
        assertDoesNotThrow(() -> BonusNumberValidator.validate("7"));
    }
}
