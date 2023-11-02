package lotto.io.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static lotto.exception.ExceptionMessage.InputException.WINNING_NUMBER_MUST_BE_SPLIT_BY_COMMA;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningNumberValidatorTest {
    @Test
    @DisplayName("당첨번호에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> WinningNumberValidator.validate("1,2,3,4, 5, 6,  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("당첨번호의 각 번호들이 숫자가 아니면 예외가 발생한다")
    void throwExceptionByInputIsNotNumeric() {
        assertThatThrownBy(() -> WinningNumberValidator.validate("1,2,3,a,4,5,b,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBER_MUST_BE_SPLIT_BY_COMMA.message);
    }

    @Test
    @DisplayName("당첨번호 검증에 성공한다")
    void success() {
        assertDoesNotThrow(() -> WinningNumberValidator.validate("1,2,3,4,5,6"));
    }
}
