package lotto.dto;

import lotto.domain.lotto.Lottos;

public class LottoGameInfo {
    private final int amount;
    private final Lottos lottos;

    public LottoGameInfo(int amount, Lottos lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public int getAmount() {
        return amount;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
