package lotto;

import lotto.constants.ErrorMessage;
import lotto.util.WinningNumbersValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨 번호 검증 테스트")
public class WinningNumberTest {

    @DisplayName("입력 값 검증")
    @Nested
    class ValidatorTest {
        //쉼표가 포함되어야 한다.
        @DisplayName("당첨 번호에 쉼표(,)가 없다면 예외가 발생한다.")
        @Test
        void inputWinningNumberWithoutCommaSeparator() {
            String winningNumbers = "1.2.3.4.5.6";
            Assertions.assertThatThrownBy(() -> WinningNumbersValidator.validate(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.WINNING_NUMBER_WRONG_SEPARATOR.getMessage());
        }

        @DisplayName("당첨 번호를 쉼표(,)를 기준으로 나눌 때, 6개가 아니면 예외가 발생한다.")
        @ParameterizedTest(name = "당첨 번호=\"{0}\"")
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        void inputWinningNumberWrongLength(String winningNumbers) {
            Assertions.assertThatThrownBy(() -> WinningNumbersValidator.validate(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }

        //쉼표로 나누었을 때, 각 String은 숫자여야 한다.
        @DisplayName("당첨 번호를 쉼표(,)를 기준으로 나눌 때, 각 문자열이 숫자가 아니면 예외가 발생한다.")
        @Test
        void inputWinningNumberNoDigit() {
            String winningNumbers = "aa,1,2,3,4,5";
            Assertions.assertThatThrownBy(() -> WinningNumbersValidator.validate(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
        }
    }
}
