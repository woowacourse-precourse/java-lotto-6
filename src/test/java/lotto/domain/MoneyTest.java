package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000})
    void 금액이_음수라면_예외를_발생시킨다(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 음수가 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 1000, 10000})
    void 금액은_0보다_크거나_같아야_한다(int money) {
        assertThatCode(() -> new Money(money))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "3000,3", "4000,4", "5000,5"})
    void 주어진_금액으로부터_로또_개수를_구할_수_있다(int purchaseMoney, int expectedCount) {
        // given
        Money money = new Money(purchaseMoney);

        // when
        int actualCount = money.getCountForPrice(1000);

        // then
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,150,0.15", "2000,500000,250.0", "7000,100000,14.286"})
    void 수익률을_구할_수_있다(int purchaseMoney, int winningMoney, double expectedRatio) {
        // given
        Money money = new Money(winningMoney);

        // when
        double actualRatio = money.getRatio(new Money(purchaseMoney));

        // then
        assertThat(actualRatio)
                .isEqualTo(expectedRatio, offset(0.4d));
    }
}
