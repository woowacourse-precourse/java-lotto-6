package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

class TicketServiceTest {
    @Test
    void Ticket_발급_테스트() {
        Ticket ticket = TicketService.createTicket(10000);
        assertThat(ticket.getLottos().size()).isEqualTo(10);
    }

    @Test
    void Ticket_수익률_테스트() {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        Ticket ticket = new Ticket(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8));

        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        double winningRate = TicketService.getProfitRate(ticket, winningNumbers, bonusNumber);
        assertThat(winningRate).isEqualTo(62.5);
    }

    @Test
    void Ticket_수익률_반올림_테스트() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto lotto3 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto4 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto5 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto6 = new Lotto(List.of(11, 12, 13, 14, 15, 16));

        Ticket ticket = new Ticket(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        double winningRate = TicketService.getProfitRate(ticket, winningNumbers, bonusNumber);
        //총 수익률 -> 166.66666666...
        assertThat(winningRate).isEqualTo(166.7);
    }

    @Test
    void Ticket_최대_수익률_테스트() {
        List<Lotto> lottos = IntStream.range(0, 100)
                .mapToObj(i -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .collect(Collectors.toList());

        Ticket ticket = new Ticket(lottos);
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        double winningRate = TicketService.getProfitRate(ticket, winningNumbers, bonusNumber);
        // 1등 100번 -> 2,000,000,000(20억) * 100 = 200,000,000,000(2천억)
        // 최대 구입 금액 -> 100,000
        // 최대 수익률 -> 2,000,000,000,000 / 100,000 = 200,000,000
        assertThat(winningRate).isEqualTo(200000000.0);
    }
}