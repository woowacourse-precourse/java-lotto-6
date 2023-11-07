package lotto.model.lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lotto findLottoByIndex(int index) {
        return lottos.get(index);
    }
}
