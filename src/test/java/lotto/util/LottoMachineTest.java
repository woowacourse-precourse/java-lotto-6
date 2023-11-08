package lotto.util;

import lotto.domain.Tickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 당첨_번호_생성_로직_테스트() {
        Tickets tickets = lottoMachine.generateTickets(10000);
        int amount = tickets.getTicketAmount();
        Assertions.assertThat(amount).isEqualTo(10);

        tickets = lottoMachine.generateTickets(8000);
        amount = tickets.getTicketAmount();
        Assertions.assertThat(amount).isEqualTo(8);
    }
}
