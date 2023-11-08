package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticTest {
    @DisplayName("로또 통계 생성 테스트")
    @Test
    void getLottoStatisticTest() {
        TicketSeller ticketSeller = new TicketSeller(new ManualLottoGenerator());
        List<Ticket> tickets = IntStream.range(0, 10)
                .mapToObj(i -> ticketSeller.createTicket())
                .toList();
        DrawResult drawResult = new DrawResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker lottoChecker = new LottoChecker(tickets, drawResult);
        List<LottoResult> lottoResults = lottoChecker.checkTickets();
        LottoStatistic lottoStatistic = new LottoStatistic(lottoResults);

        assertThat(lottoStatistic.getLottoStatistic())
                .containsOnlyKeys(new LottoResult(6, false));
    }
}
