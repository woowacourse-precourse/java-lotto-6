package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("로또는 지정한 개수만큼 발행되어야 한다.")
    @Test
    void generateLottoTicketsEqualToTicketCount() {
        int lottoTicketCount = 5;
        List<Lotto> lottoTickets = LottoGenerator.generateLottoTickets(lottoTicketCount);

        assertThat(lottoTickets.size())
            .isEqualTo(lottoTicketCount);
    }

    @DisplayName("발행된 로또의 수와 발행을 요구한 수가 다르면 안된다.")
    @Test
    void generateLottoTicketsNotEqualToTicketCount() {
        int lottoTicketCount = 5;
        List<Lotto> lottoTickets = LottoGenerator.generateLottoTickets(lottoTicketCount);

        assertThat(lottoTickets.size())
            .isNotEqualTo(lottoTicketCount-1);
    }
}