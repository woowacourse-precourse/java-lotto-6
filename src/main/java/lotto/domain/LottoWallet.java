package lotto.domain;

import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos;

    public LottoWallet(int lottoCount) {
        this.lottos = LottoMachine.publish(lottoCount);
    }
}
