package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않을 경우 예외 발생")
    @Test
    void createPurchaseAmountNotDivisibleBy1000() {
        String testPurchaseAmount = "128700";

        assertThatThrownBy(() -> new Purchase(testPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
