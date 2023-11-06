package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void 로또_티켓_생성() {
        LottoTicket lottoTicket = LottoTicket.create(80_000);
        assertThat(lottoTicket.getTicketCount()).isEqualTo(80);
    }
}