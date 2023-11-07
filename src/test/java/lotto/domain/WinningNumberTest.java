package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSetting.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호가 6자리 이상 입력된다면, 예외 처리")
    void validateWinningNumber() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "6", "7");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber(numbersInput));
        assertThat(exception.getMessage()).isEqualTo(NOT_LENGTH.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복되는 수가 있다면, 예외 처리")
    void validateWinningNumber2() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "6", "6");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber(numbersInput));
        assertThat(exception.getMessage()).isEqualTo(NOT_UNIQUE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1.5", "가나다", "hello"})
    @DisplayName("당첨 번호에 수가 아닌 것이 포함되었다면, 예외 처리")
    void validateWinningNumber3(String input) {
        List<String> numbersInput = List.of(input, "2", "3", "4", "5", "6");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber(numbersInput));
        assertThat(exception.getMessage()).isEqualTo(NOT_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    @DisplayName("당첨 번호에 범위에 맞지 않은 수가 있다면, 예외 처리")
    void validateWinningNumber4(String input) {
        List<String> numbersInput = List.of(input, "2", "3", "4", "5", "6");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber(numbersInput));
        assertThat(exception.getMessage()).isEqualTo(
                format(NOT_RANGE.getMessage(), MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue())
        );
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복된다면, 예외 처리")
    void checkDuplicateBonus() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "6");
        WinningNumber winningNumber = new WinningNumber(numbersInput);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winningNumber.checkDuplicateBonus(1));
        assertThat(exception.getMessage()).isEqualTo(NOT_UNIQUE.getMessage());
    }
}