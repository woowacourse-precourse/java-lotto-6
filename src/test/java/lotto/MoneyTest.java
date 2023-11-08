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

    @DisplayName("구입 금액이 1,000원 단위로 나누어지지 않는다면 예외가 발생한다.")
    @Test
    void countTicketByRemainderExists() {
        // given
        int payMoney = 100;

        // when & then
        assertThatThrownBy(() -> new Money(payMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 비어있으면 예외가 발생한다.")
    @Test
    void countTicketByBlank() {
        // given
        int payMoney = 0;

        // when & then
        assertThatThrownBy(() -> new Money(payMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자 이외의 값이 입력되면 예외가 발생한다.")
    @Test
    void getMoneyByNotNumeric() {
        // given
        String input = "abcde";

        // when & then
        assertThatThrownBy(() -> new Money(Integer.parseInt(input)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
