package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersValidatorTest {
    Validator winningNumbersValidator = new WinningNumbersValidator();

    @DisplayName("당첨 번호로 Null 및 공백 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void testWhenWinningNumbersIsNullOrBlank(String winningNumbers) {
        IllegalArgumentException winningNumbersException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> winningNumbersValidator.validate(winningNumbers));
        assertThat(winningNumbersException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호로 유효하지 않은 패턴으로 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1,two,3,4,5,6", "10/12/23/34/45/16", "11, 22, 33, 44, 25, 26"})
    void testWhenWinningNumbersIsInvalidPattern(String winningNumbers) {
        IllegalArgumentException winningNumbersException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> winningNumbersValidator.validate(winningNumbers));
        assertThat(winningNumbersException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호로 범위 밖의 숫자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0,1,2,3,4,5", "12,24,36,40,44,46"})
    void testWhenInvalidRangeNumberInWinningNumbers(String winningNumbers) {
        IllegalArgumentException winningNumbersException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> winningNumbersValidator.validate(winningNumbers));
        assertThat(winningNumbersException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호로 당첨 번호 개수보다 많거나 적은 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1,2,3,4,5,6,7", "11,12,13,14,15"})
    void testWhenInvalidSizeNumberInWinningNumbers(String winningNumbers) {
        IllegalArgumentException winningNumbersException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> winningNumbersValidator.validate(winningNumbers));
        assertThat(winningNumbersException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("당첨 번호로 중복된 숫자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1,2,3,4,6,6", "11,11,22,22,33,33"})
    void testWhenDuplicatedNumbersInWinningNumbers(String winningNumbers) {
        IllegalArgumentException winningNumbersException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> winningNumbersValidator.validate(winningNumbers));
        assertThat(winningNumbersException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("적절한 당첨 번호 입력 시 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,12,14,35,39,45"})
    void testWhenWinningNumbersIsValid(String winningNumbers) {
        Assertions.assertDoesNotThrow(() -> winningNumbersValidator.validate(winningNumbers));
    }
}
