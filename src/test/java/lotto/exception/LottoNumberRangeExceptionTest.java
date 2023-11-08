package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoNumberRangeExceptionTest {
    @DisplayName("1에서 45 사이의 유효한 숫자는 예외가 발생하지 않는다.")
    @Test
    void testNumberRangeException_ValidNumber() {
        // Arrange
        int validNumber = 42;

        // Act & Assert
        assertThatCode(() -> LottoNumberRangeException.NumberRangeException(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("범위를 벗어난 숫자는 NumberFormatException 예외가 발생한다.")
    @Test
    void testNumberRangeException_OutOfRange() {
        // Arrange
        int outOfRangeNumber = 50;

        // Act & Assert
        assertThatCode(() -> LottoNumberRangeException.NumberRangeException(outOfRangeNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR]1~45사이만 입력가능합니다");
    }

    @DisplayName("음수 숫자는 NumberFormatException 예외가 발생한다.")
    @Test
    void testNumberRangeException_NegativeNumber() {
        // Arrange
        int negativeNumber = -5;

        // Act & Assert
        assertThatCode(() -> LottoNumberRangeException.NumberRangeException(negativeNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR]1~45사이만 입력가능합니다");
    }
}