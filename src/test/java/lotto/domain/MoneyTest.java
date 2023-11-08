package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    private final Money money = new Money(10000);

    @DisplayName("사용자에게 입력받은 금액을 통해 로또 티켓들을 가지고 있는 Tickets 객체를 반환한다.")
    @Test
    void provideMoneyAndGenerateTickets() {
        assertThat(money.createTicket()).isInstanceOf(Tickets.class);
    }

    @DisplayName("사용자가 입력한 금액과 상금 총액을 비교하여 수익률을 반환한다.")
    @Test
    void calcRateOfReturnByPrizeAndMoney() {
        double rateOfReturn = money.calcRateOfReturn(30000000L);
        assertThat(rateOfReturn).isEqualTo(300000.0);
    }
}
