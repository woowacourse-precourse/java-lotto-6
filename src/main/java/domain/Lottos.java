package domain;

import java.util.List;
import lotto.Lotto;

public class Lottos {
    private final List<Lotto> lottoLists;

    public Lottos(List<Lotto> lottoLists) {
        this.lottoLists = lottoLists;
    }

    public List<Lotto> getLottoLists() {
        return lottoLists;
    }
}
