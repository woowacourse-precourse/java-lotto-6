package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class MoneyTest {

    @Test
    void 최소값보다_작은_값을_받았을_때_예외_처리() {
        int money = 100;

        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 배수가_1000단위가_아닐시_예외_처리() {
        int money = 1001;

        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_입력값을_받았을_때() {
        Money money = new Money(12000);
        int result = money.getPurchaseAmount();

        int expect = 12000;

        assertThat(expect).isEqualTo(result);
    }

    @Test
    void 수익률_반환하기() {
        int purchaseAmount = Rank.SECOND.getPrizeMoney();
        int profit = Rank.SECOND.getPrizeMoney();
        Money money = new Money(purchaseAmount);

        double result = money.getEarningRate(profit);
        double expect = 100.0;
        assertThat(expect).isEqualTo(result);
    }

}