package lotto.domain.lotto.userLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.lotto.LottoCondition.PRICE;

class PurchasePriceTest {

    @DisplayName("구입 금액이 로또 금액 미만이면 예외가 발생한다.")
    @Test
    void createPurchasePriceByLessThanLottoPrice() {
        Assertions.assertThatThrownBy(() -> new PurchasePrice(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 " + PRICE.getValue()+ "원 단위로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 로또 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchasePriceByIndivisible() {
        Assertions.assertThatThrownBy(() -> new PurchasePrice(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 " + PRICE.getValue()+ "원 단위로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 로또 금액 단위이면 성공한다.")
    @Test
    void createPurchasePriceByDivisible() {
        Assertions.assertThat(new PurchasePrice(2000)).isNotNull();
    }
}
