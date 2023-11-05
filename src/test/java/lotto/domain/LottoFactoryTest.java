package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
    @DisplayName("올바른 개수의 로또 티켓이 생성되어야 한다.")
    @Test
    void testCorrectNumberOfLottoTicketsAreGenerated() {
        // given
        long ticketCounts = 5;
        LottoFactory lottoFactory = new LottoFactory(ticketCounts);

        // when
        List<Lotto> tickets = lottoFactory.getTickets();

        // then
        assertThat(tickets).hasSize((int) ticketCounts);
    }

}

