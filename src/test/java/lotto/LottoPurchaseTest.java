package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {

    @DisplayName("구매 금액이 1000원 단위가 아닐 때 예외를 발생시킨다.")
    @Test
    void createLottoPurchaseByInvalidAmount() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        int invalidAmount = 1001;

        assertThatThrownBy(() -> lottoPurchase.validateAmount(invalidAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("구매 금액이 1000원 단위일 때 구매 금액을 반환한다.")
    @Test
    void createLottoPurchaseByValidAmount() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        int validAmount = 1000;

        assertThat(lottoPurchase.validateAmount(validAmount)).isEqualTo(validAmount);
    }

}
