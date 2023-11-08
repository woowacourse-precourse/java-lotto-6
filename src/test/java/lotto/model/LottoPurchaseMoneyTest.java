package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseMoneyTest {

    @DisplayName("정상적인 로또 구입 금액을 입력한다.")
    @Test
    void createLottoPurchaseMoney() {
        // given
        int amount = 5000;

        // when
        LottoPurchaseMoney lottoPurchaseMoney = LottoPurchaseMoney.from(amount);

        // then
        assertThat(lottoPurchaseMoney.toInt()).isEqualTo(amount);
    }

    @DisplayName("로또 구입금액이 1000~100000 범위를 벗어나면 예외를 발생한다.")
    @Test
    void createLottoPurchaseMoneyOutOfRange() {
        // given
        int case1 = 900;
        int case2 = 1_000_000;

        // when & then
        assertThatThrownBy(() -> LottoPurchaseMoney.from(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoPurchaseMoney.from(case2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 1000으로 나누어떨어지지 않으면 예외를 발생한다.")
    @Test
    void createLottoPriceNotMultipleOfLottoPrice() {
        // given
        int amount = 1100;

        // when & then
        assertThatThrownBy(() -> LottoPurchaseMoney.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
