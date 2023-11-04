package lotto.dto;

import lotto.domain.lotto.Lottos;

public class LottoGameInfo {
    private final long amount;
    private final Lottos lottos;

    public LottoGameInfo(long amount, Lottos lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public long getAmount() {
        return amount;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
