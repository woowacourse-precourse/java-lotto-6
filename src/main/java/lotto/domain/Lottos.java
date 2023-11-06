package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoTickets;

    private Lottos(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static Lottos from(List<Lotto> lottoTickets) {
        return new Lottos(lottoTickets);
    }
}
