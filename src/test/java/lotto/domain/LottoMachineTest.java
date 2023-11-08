package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 티켓을 발행하면 로또 번호가 생성된다.")
    @Test
    void issueTicket() {
        LottoTicket ticket = lottoMachine.issueTicket();
        assertThat(ticket.getLotto().getNumbers().size()).isEqualTo(Lotto.LOTTO_NUMBER_COUNT);
    }
}