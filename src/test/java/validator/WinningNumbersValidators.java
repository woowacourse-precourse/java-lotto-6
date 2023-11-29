package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersValidators {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,7"})
    void createWinningNumbersByOverSize(final String numbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 문자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,ㅇ.ㄹㅇㄹ", ",,,,"})
    void createWinningNumbersNumeric(final String numbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,46"})
    void createWinningNumbersRange(final String numbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
