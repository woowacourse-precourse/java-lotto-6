package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Tickets;

public class LottoGameService {

    public Lottos buyLottos(Tickets tickets) {
        List<Lotto> lottos = IntStream.range(0, tickets.getNumberOfTickets())
            .mapToObj(i -> Lotto.generateRandomLottoNumbers())
            .toList();
        return Lottos.of(lottos);
    }

}

