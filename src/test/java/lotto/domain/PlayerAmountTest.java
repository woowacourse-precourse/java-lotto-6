package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerAmountTest {

  @DisplayName("구입 금액에 빈칸 입력")
  @Test
  void isEmpty() {
    String input = "";

    assertThatThrownBy(() -> PurchaseAmountValidator.isEmptyString(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("구입 금액에 정수가 아닌 수 입력")
  @Test
  void isAllIntegers() {
    String input = "a";

    assertThatThrownBy(() -> PurchaseAmountValidator.isAllIntegersValid(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("구입 금액에 정수가 아닌 수 입력")
  @Test
  void isNotDiv() {
    String input = "1200";

    assertThatThrownBy(() -> PurchaseAmountValidator.isDivisibleBy1000(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("구입 금액에 1000보다 작은 금액 입력")
  @Test
  void isValue() {
    String input = "900";

    assertThatThrownBy(() -> PurchaseAmountValidator.isAmountGreaterThanOrEqualTo1000(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
