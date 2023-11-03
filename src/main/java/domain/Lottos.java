package domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoLists;

    public Lottos(List<Lotto> lottoLists) {
        this.lottoLists = lottoLists;
    }

    public List<Lotto> getLottoLists() {
        return lottoLists;
    }
}
