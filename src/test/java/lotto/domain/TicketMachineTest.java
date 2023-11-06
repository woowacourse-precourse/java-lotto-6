package lotto.domain;

import lotto.utils.GameRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketMachineTest {
    @DisplayName("구입금액에 따라 티켓을 반환한다.")
    @Test
    void returnTicketByMoney() {
        Money money = Money.from(5000);
        int expectedTicket = 5000 / GameRules.MINIMUN_UNIT.getValue();
        int actualTicket = TicketMachine.getTicket(money);
        assertThat(actualTicket).isEqualTo(expectedTicket);
    }
}