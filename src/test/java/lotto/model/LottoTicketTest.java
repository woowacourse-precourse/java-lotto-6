package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    void generateTickets() {
        String amount = "8000";
        LottoCount count = LottoCount.createLottoCount(amount);

        LottoTickets lottoTickets = LottoTickets.generateTickets(count);
        assertThat(lottoTickets.getTickets().size()).isEqualTo(count.getLottoCount());
    }

}