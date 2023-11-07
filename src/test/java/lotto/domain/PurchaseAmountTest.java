package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @DisplayName("금액이 음수이면 예외가 발생한다.")
    @Test
    void negativeAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("물건 금액으로 나눈 결과를 반환한다")
    @Test
    void divideTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
        int objectAmount = 1000;
        Assertions.assertThat(purchaseAmount.changeBy(objectAmount)).isEqualTo(3);
    }

 }
