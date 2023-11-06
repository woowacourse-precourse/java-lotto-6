package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("입력받은 값이 구매단위로 떨이지지 않는 경우 IllegalArgumentException 예외가 발생한다.")
    void not_divide_purchase_unit() {
        int purchaseAmount = LottoConfig.PURCHASING_UNIT.getValue() + 1;
        Assertions.assertThatThrownBy(() -> Player.initialize(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 값이 구매단위 보다 작은 경우 IllegalArgumentException 예외가 발생한다.")
    void under_purchase_unit() {
        int purchaseAmount = LottoConfig.PURCHASING_UNIT.getValue() - 1;
        Assertions.assertThatThrownBy(() -> Player.initialize(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바르게 초기화된 Plyaer의 로또 구매 갯수는 입력 가격 / 구매단위 한 값과 같아야한다.")
    void correct_initialize() {
        int purchaseQuantity = 5;
        int purchaseAmount = LottoConfig.PURCHASING_UNIT.getValue() * purchaseQuantity;

        Player player = Player.initialize(purchaseAmount);

        Assertions.assertThat(player.getPurchaseQuantity() == purchaseQuantity).isTrue();
    }
}