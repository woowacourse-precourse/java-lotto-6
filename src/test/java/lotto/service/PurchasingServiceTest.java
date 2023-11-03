package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasingServiceTest {

    PurchasingService purchasingService = new PurchasingService();

    @DisplayName("로또 구매 금액이 1,000원 보다 적으면 예외가 발생한다.")
    @Test
    void createBuyerUnderAmount() {
        assertThatThrownBy(() -> purchasingService.purchaseLotto("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또를 한 장 이상 구매해야 합니다. (로또 1장 1,000원");
    }

    @DisplayName("로또 구매 금액의 단위가 1,000원이 아니면 예외가 발생한다.")
    @Test
    void createBuyerWrongUnit() {
        assertThatThrownBy(() -> purchasingService.purchaseLotto("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1,000원 단위로 구매 가능합니다. (로또 1장 1,000원");
    }
}