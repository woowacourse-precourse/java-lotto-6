package lotto.domain.amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setup() {
        purchaseAmount = PurchaseAmount.from(3000);
    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않는다면 예외를 발생한다.")
    @Test
    void createAmountByNumber() {
        assertThatThrownBy(() -> PurchaseAmount.from(1001))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 미만이라면 예외를 발생한다.")
    @Test
    void createAmountLessThanThousand() {
        assertThatThrownBy(() -> PurchaseAmount.from(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}