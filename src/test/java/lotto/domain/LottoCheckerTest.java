package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCheckerTest {
    @DisplayName("LottoChecker를 생성하고, 당첨 결과를 반환한다.")
    @Test
    void LottoStat() {
        TicketSeller ticketSeller = new TicketSeller(new ManualLottoGenerator());
        List<Ticket> tickets = IntStream.range(0, 10)
                .mapToObj(i -> ticketSeller.createTicket())
                .toList();
        DrawResult drawResult = new DrawResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker lottoChecker = new LottoChecker(tickets, drawResult);
        assertThat(lottoChecker.checkTickets())
                .containsOnly(new LottoResult(6, false));
    }
}
