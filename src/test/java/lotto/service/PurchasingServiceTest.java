package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasingServiceTest {

    PurchasingService purchasingService = new PurchasingService();

    @DisplayName("로또 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void purchaseLottoBuyerByNotNumber() {
        assertThatThrownBy(() -> purchasingService.purchaseLotto("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("로또 구매 금액이 1,000원 보다 적으면 예외가 발생한다.")
    @Test
    void purchaseLottoByUnderAmount() {
        assertThatThrownBy(() -> purchasingService.purchaseLotto("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또를 한 장 이상 구매해야 합니다. (로또 1장 1,000원)");
    }

    @DisplayName("로또 구매 금액의 단위가 1,000원이 아니면 예외가 발생한다.")
    @Test
    void purchaseLottoByWrongUnit() {
        assertThatThrownBy(() -> purchasingService.purchaseLotto("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1,000원 단위로 구매 가능합니다. (로또 1장 1,000원)");
    }

    @DisplayName("입력된 금액으로 구매 가능한 로또 수량을 발행해야 한다.")
    @Test
    void issueLottoByPurchaseAmount() {
        purchasingService.purchaseLotto("10000");
        assertThat(purchasingService.getBuyerPurchaseQuantity()).isEqualTo(10);
    }
}