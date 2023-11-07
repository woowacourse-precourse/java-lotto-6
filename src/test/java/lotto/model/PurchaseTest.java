package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    private Purchase purchase;
    @BeforeEach
    void setUp() {
        purchase = new Purchase();
    }
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않을 경우 예외 발생")
    @Test
    void createPurchaseAmountNotDivisibleBy1000() {
        int testPurchaseAmount = 128700;

        assertThatThrownBy(() -> purchase.setPurchase(testPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 0일 경우 예외 발생")
    @Test
    void createPurchaseAmountByZero() {
        int testPurchaseAmount = 0;

        assertThatThrownBy(() -> purchase.setPurchase(testPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액을 1000으로 나눈 숫자가 구매 횟수")
    @Test
    void creatPurchaseNumberByPurchaseAmount() {
        int testPurchaseAmount = 50000;
        int testPurchaseNumber = 50;

        purchase.setPurchase(testPurchaseAmount);

        assertThat(purchase.getPurchaseNumber()).isEqualTo(testPurchaseNumber);
    }
}
