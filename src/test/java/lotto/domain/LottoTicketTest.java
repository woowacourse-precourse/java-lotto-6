package lotto.domain;

import lotto.service.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTicketTest {
    @DisplayName("티켓 개수만큼 로또가 생성되고, 생성된 로또를 모은 로또 티켓이 발행된다.")
    @Test
    void createLottoByTicketCount() {
        int expectedValue = 3;
        LottoTicket lottoTicket = LottoMachine.createLottoTicket(expectedValue);
        int actualValue = lottoTicket.getSize();

        assertThat(expectedValue).isEqualTo(actualValue);
    }
}