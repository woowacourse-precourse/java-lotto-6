package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {
    @DisplayName("입력한 가격이 숫자가 아닐 경우 발생")
    @Test
    void 입력가격_정수확인() {
        assertThatThrownBy(() -> new PurchasePrice("15oook"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 가격이 1000으로 나누어 떨어지지 않을 경우 발생")
    @Test
    void 입력가격_1000단위확인() {
        assertThatThrownBy(() -> new PurchasePrice("15200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}