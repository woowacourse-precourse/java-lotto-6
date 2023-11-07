package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoTicket;

    private Lottos(final List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static Lottos of(final List<Lotto> lottoTicket) {
        return new Lottos(lottoTicket);
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
