package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 500, 999})
    public void 로또_구매_금액이_최소_금액인_1000원을_넘지_못하면_예외를_발생시킨다(int money) {
        // when, then
        Assertions.assertThatThrownBy(() -> new LottoPurchaseMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1300, 2500, 3350})
    public void 로또_구매_금액_1000원_단위가_아니면_예외를_발생시킨다(int money) {
        // when, then
        Assertions.assertThatThrownBy(() -> new LottoPurchaseMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 4000, 8000})
    public void 로또_구매_금액이_1000원_이상이고_1000원_단위이면_LottoPurchaseMoney_객체를_생성할_수_있다(int money) {
        // when
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(money);

        // then
        Assertions.assertThat(lottoPurchaseMoney).isNotNull();
    }
}