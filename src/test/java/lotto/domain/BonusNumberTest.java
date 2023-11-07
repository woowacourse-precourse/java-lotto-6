package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSetting.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    private static WinningNumber getWinningNumber() {
        List<String> numbersInput = List.of("1", "2", "3", "4", "5", "6");
        return new WinningNumber(numbersInput);
    }

    @ParameterizedTest
    @CsvSource({"1.5", "가나다", "hello"})
    @DisplayName("보너스 번호가 수가 아니라면, 예외 처리")
    void validateBonusNumber(String input) {

        WinningNumber winningNumber = getWinningNumber();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(winningNumber, input));

        assertThat(exception.getMessage()).isEqualTo(NOT_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    @DisplayName("보너스 번호가 범위에 맞지 않는다면, 예외 처리")
    void validateBonusNumber2(String input) {

        WinningNumber winningNumber = getWinningNumber();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(winningNumber, input));

        assertThat(exception.getMessage()).isEqualTo(
                format(NOT_RANGE.getMessage(), MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue())
        );
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    @DisplayName("보너스 번호가 당첨 번호와 중복이라면, 예외 처리")
    void validateBonusNumber3(String input) {

        WinningNumber winningNumber = getWinningNumber();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(winningNumber, input));

        assertThat(exception.getMessage()).isEqualTo(NOT_UNIQUE.getMessage());
    }
}