package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액을 입력하면 1,000원 단위로 나눠 티켓 개수를 세어준다.")
    @Test
    void countTicket() {
        // given
        int payMoney = 5000;

        // when
        Money money = new Money(payMoney);

        // then
        assertThat(money).isNotNull().isInstanceOf(Money.class);
        assertThat(money.getTicket()).isEqualTo(5);
    }
}
