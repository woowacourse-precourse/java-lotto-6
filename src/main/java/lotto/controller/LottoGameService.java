package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Tickets;
import lotto.view.InputView;

public class LottoGameService {


    public Tickets getTickets(int purchaseAmount) {

        return Tickets.of(purchaseAmount);
    }

    public Lottos buyLottos(Tickets tickets) {
        List<Lotto> lottos = IntStream.range(0, tickets.getNumberOfTickets())
            .mapToObj(i -> Lotto.generateRandomLottoNumbers())
            .toList();
        return Lottos.of(lottos);
    }

}

