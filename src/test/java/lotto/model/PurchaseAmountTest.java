package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void 정상적인_구입금액_입력() {
        // given
        int amount = 5000;

        // when
        PurchaseAmount purchaseAmount = PurchaseAmount.from(amount);

        // then
        assertThat(purchaseAmount.toInt()).isEqualTo(amount);
    }

    @Test
    void 로또_가격보다_작은_구입금액_예외() {
        // given
        int amount = 900;

        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_가격으로_나누어_떨어지지_않는_구입금액_예외() {
        // given
        int amount = 1100;

        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 백만보다_큰_구입금액_입력_예외() {
        // given
        int amount = 1_001_000;

        // when & then
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
