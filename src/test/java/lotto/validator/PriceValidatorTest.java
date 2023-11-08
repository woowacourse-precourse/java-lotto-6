package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.message.ExceptionMessage;

public class PriceValidatorTest {

  @Test
  @DisplayName("로또 구입 금액이 숫자가 아닐 때 예외를 던진다")
  void validatePriceNonNumber() {
    String input = "abc";

    assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.NON_NUMBER);
  }

  @Test
  @DisplayName("로또 구입 금액이 공백 일 때 예외를 던진다")
  void validatePriceBlank() {
    String input = " ";

    assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.BLANK);
  }

  @Test
  @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 때 예외를 던진다")
  void validatePriceNotThousand() {
    String input = "1100";

    assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionMessage.INPUT_PRICE);
  }

  @Test
  @DisplayName("올바른 구입 금액을 입력시 예외를 던지지 않는다.")
  void validateCorrectPrice() {
    String input = "2000";

    assertThatCode(() -> InputValidator.validatePurchaseAmount(input))
        .doesNotThrowAnyException();
  }

}
