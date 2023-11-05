package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void validate_1000으로_나누어_떨어지지_않는경우() {
        assertThatThrownBy(() -> new Money(1100L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_한장도_못사는경우() {
        assertThatThrownBy(() -> new Money(0L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMoney() {
        Money money = new Money(8000L);

        assertThat(money.getMoney()).isEqualTo(8000L);
    }

    @Test
    void getTicket() {
        Money money = new Money(8000L);

        assertThat(money.getTicket()).isEqualTo(8L);
    }
}
