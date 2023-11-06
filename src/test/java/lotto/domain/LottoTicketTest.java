package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void 로또_티켓_생성() {
        LottoTicket lottoTicket = LottoTicket.create(80000);
        assertThat(lottoTicket.getLottos().size()).isEqualTo(80);
    }
}