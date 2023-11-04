package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final int count;
    private final List<Lotto> lottos;

    public LottoTicket(int count, List<Lotto> lottos) {
        this.count = count;
        this.lottos = lottos;
    }
}