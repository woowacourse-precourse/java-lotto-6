package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {

    @DisplayName("입력된 구매금액을 토대로 Purchase 객체가 생성된다.")
    @Test
    void fromPurchaseAmount() {
        // given
        String input = "11000";

        // when
        Purchase purchase = Purchase.fromPurchaseAmount(input);

        // then
        assertThat(purchase.getPurchaseCount()).isEqualTo(11);
    }

    @DisplayName("입력된 구매금액이 숫자가 아니라면 Exception 발생한다.")
    @Test
    void validateNumeric() {
        // given
        String input = "1000a";

        // when // then
        assertThatThrownBy(() -> Purchase.fromPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 숫자로만 이루어져야 합니다.");
    }

    @DisplayName("입력된 구매금액이 1000원 단위가 아니라면 Exception 발생한다.")
    @Test
    void validateAmountInThousands() {
        // given
        String input = "1001";

        // when // then
        assertThatThrownBy(() -> Purchase.fromPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
    }

}