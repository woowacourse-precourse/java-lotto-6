package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    LottoTicket lottoTicket = new LottoTicket();

    @Test
    void testLottoTicketGenerated() {
        // given
        int count = 3;

        // when
        lottoTicket.generateLottoTicket(3);

        // then
        Assertions.assertThat(lottoTicket.getLottos()).hasSize(3);
    }
}