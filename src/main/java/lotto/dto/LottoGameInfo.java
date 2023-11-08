package lotto.dto;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.Lottos;

public class LottoGameInfo {
    private final Cash cash;
    private final Lottos lottos;

    public LottoGameInfo(Cash cash, Lottos lottos) {
        this.cash = cash;
        this.lottos = lottos;
    }

    public long getCash() {
        return cash.getCash();
    }

    public Lottos getLottos() {
        return lottos;
    }
}
