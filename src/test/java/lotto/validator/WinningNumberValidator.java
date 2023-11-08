package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.message.ExceptionMessage;

public class WinningNumberValidator {

  @Test
  @DisplayName("당첨 번호가 쉼표로 구분되지 않으면 예외를 던진다")
  void validateWinningNumberComma() {
    String input = "1/2/3/4/5/6";

    assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.WINNING_NUMBER);
  }

  @Test
  @DisplayName("당첨 번호 중 숫자가 아닌 값이 있으면 예외를 던진다")
  void validateWinningNonNumber() {
    String input = "1,2,3,4,5,a";

    assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.WINNING_NUMBER);
  }

  @Test
  @DisplayName("당첨 번호가 6개가 아니면 예외를 던진다")
  void validateWinningNotLengthSix() {
    String input = "1,2,3,4,5,6,7";

    assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.WINNING_NUMBER);
  }

  @Test
  @DisplayName("당첨 번호에 쉼표가 계속되면 예외를 던진다")
  void validateWinningCommaAndComma() {
    String input = "1,2,3,4,5,,7";

    assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.WINNING_NUMBER);
  }

  @Test
  @DisplayName("당첨 번호가 쉼표로 시작되면 예외를 던진다")
  void validateWinningStartComma() {
    String input = "1,2,3,4,5,,7";

    assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.WINNING_NUMBER);
  }

  @Test
  @DisplayName("올바른 당첨 번호 입력시 예외를 던지지 않는다.")
  void validateCorrectWinningNumber() {
    String input = "1,2,3,4,5,6";

    assertThatCode(() -> InputValidator.validateWinningNumbers(input))
        .doesNotThrowAnyException();
  }

}
