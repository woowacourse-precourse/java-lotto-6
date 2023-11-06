package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 주어진_금액으로부터_로또_개수를_구할_수_있다(int purchaseMoney, int expectedQuantity) {
        // given
        Money money = new Money(purchaseMoney);

        // when
        int actualQuantity = money.calculateQuantity(1000);

        // then
        assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }
}
