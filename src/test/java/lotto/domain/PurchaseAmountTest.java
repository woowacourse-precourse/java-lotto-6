package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

  @DisplayName("구입금액이 1000 단위가 아니라면 예외가 발생한다.")
  @Test
  void createPurchaseAmountByInvalidAmount() {
    assertThatThrownBy(() -> new PurchaseAmount(1500))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
