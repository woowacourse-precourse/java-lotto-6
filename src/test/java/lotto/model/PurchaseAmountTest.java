package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseMoneyTest {

  @Test
  @DisplayName("구매 금액을 1000으로 나눴을 때 나머지가 존재할 수 없다.")
  void testCreatePurchaseAmount() {
    int purchaseMoney = 1001;

    assertThatThrownBy(() -> new PurchaseMoney(purchaseMoney))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("1000원을 구매하면 1장을 반환한다.")
  void testGetAmount() {
    int purchaseMoney = 1000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(purchaseMoney);

    assertThat(purchasedMoney.getPurchaseAmount()).isEqualTo(1);
  }
}