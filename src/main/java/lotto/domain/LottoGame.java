package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class LottoGame {
    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
