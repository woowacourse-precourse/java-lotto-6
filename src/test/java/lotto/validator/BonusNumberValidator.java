package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.common.message.ExceptionMessage;

public class BonusNumberValidator {

  List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

  @Test
  @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외를 던진다")
  void validateDuplicateBonusNumber() {
    String bonusNumber = "6";

    assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBER);
  }

  @Test
  @DisplayName("보너스 번호가 숫자가 아닐 때 예외를 던진다")
  void validateNonNumberBonusNumber() {
    String bonusNumber = "abc";

    assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.NON_NUMBER);
  }

  @Test
  @DisplayName("보너스 번호가 1-45 범위가 아닐 때 예외를 던진다")
  void validateNotRangeBonusNumber() {
    String bonusNumber = "100";

    assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.OVER_RANGE);
  }

  @Test
  @DisplayName("올바른 보너스 번호 입력시 예외를 던지지 않는다.")
  void validateCorrectBonusNumber() {
    String bonusNumber = "7";

    assertThatCode(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
        .doesNotThrowAnyException();
  }

}
