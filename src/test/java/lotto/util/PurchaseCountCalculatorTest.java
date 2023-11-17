package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseCountCalculatorTest {

    @Test
    @DisplayName("구매 금액과 물건 금액으로 구매 갯수를 계산할 수 있다.")
    void calculatePurchaseCountTest() {
        int count = PurchaseCountCalculator.calculatePurchaseCount(1_000, 100);
        assertThat(count).isEqualTo(10);
    }

    @Test
    @DisplayName("구매 금액이 물건 금액으로 나누어 떨어지지 않을 떄 예외를 발생시킨다.")
    void calculatePurchaseCountRemainderNotZeroTest() {
        assertThatThrownBy(() -> PurchaseCountCalculator.calculatePurchaseCount(1_000, 7))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
