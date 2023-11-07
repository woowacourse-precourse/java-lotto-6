package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PurchaseManagerTest {
    @DisplayName("1000원보다 적은 금액을 입력하면 오류가 발생한다.")
    @Test
    void purchaseAmount1() {
        assertThatThrownBy(() -> new PurchaseManager("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("거스름돈이 발생하면 오류가 발생한다.")
    @Test
    void purchaseAmount2() {
        assertThatThrownBy(() -> new PurchaseManager("2100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자가 포함되면 오류가 발생한다")
    @Test
    void purchaseAmount3() {
        assertThatThrownBy(() -> new PurchaseManager("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}