package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void 입력한_금액이_1000원_단위가_아니면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Money(1800L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_금액이_음수인_경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Money(-1000L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 곱셈_테스트() {
        // given
        final int winningCount = 3;
        final Money money = new Money(1000L);

        // when
        final Money multiplied = money.multiply(winningCount);

        // then
        Assertions.assertThat(multiplied.getMoney()).isEqualTo(3000L);
    }

    @Test
    public void 나누기_테스트() {
        // given
        final Money money = new Money(5000L);
        final Money another = new Money(1000L);

        // when
        final BigDecimal divide = money.divide(another);

        // then
        Assertions.assertThat(divide).isEqualTo(BigDecimal.valueOf(5.000).setScale(4, RoundingMode.HALF_UP));
    }
}