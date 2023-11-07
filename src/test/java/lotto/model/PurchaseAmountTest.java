package lotto.model;

import static lotto.configurations.SettingValues.PRICE_OF_LOTTO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @DisplayName("객체 생성 성공")
    @Test
    void createPurchaseAmountComplete() {
        Long paidMoney = 10000L;
        Integer numberOfLotto = Math.toIntExact(paidMoney / PRICE_OF_LOTTO.get());
        PurchaseAmount purchaseAmount = new PurchaseAmount(paidMoney);
        assertEquals(numberOfLotto, purchaseAmount.getNumberOfLotto());
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByInvalidUnit() {
        assertThatThrownBy(() -> new PurchaseAmount(1001L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매하는 티켓의 수가 Integer 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByOutOfInteger() {
        assertThatThrownBy(() -> new PurchaseAmount((long) Integer.MAX_VALUE + 1L))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
