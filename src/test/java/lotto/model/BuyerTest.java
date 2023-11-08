package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

    @DisplayName("구입금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    public void createBuyerWithNotUnitOf1000Budget() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Buyer(1500));
    }

    @DisplayName("구입금액이 1000원 이하인 경우 예외 발생")
    @Test
    public void createBuyerWithTooSmallBudget() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Buyer(0));
    }
}
