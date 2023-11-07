package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public class TicketService {
    public static Ticket createTicket(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = IntStream.range(0, lottoCount).mapToObj(i -> LottoService.createLotto())
                .collect(Collectors.toList());
        return new Ticket(lottos);
    }
}
