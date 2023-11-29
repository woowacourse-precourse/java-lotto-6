package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.message.ExceptionMessage.*;

public class WinningNumbersValidators {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,7"})
    void createWinningNumbersByOverSize(final String numbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage((String.format(SIZE_OVER_MESSAGE.getValue(), "로또")));
    }

    @DisplayName("당첨 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersNumericVer1() {
        String numbers = "1,,d,fd,fdf,dfef";
        assertThatThrownBy(() -> WinningNumbersValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue()));;
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumbersRange() {
        String numbers = "1,3,45,100,1,0";
        assertThatThrownBy(() -> WinningNumbersValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage((String.format(RANGE_START_BETWEEND_END.getValue(), 1, 45)));
    }
}
