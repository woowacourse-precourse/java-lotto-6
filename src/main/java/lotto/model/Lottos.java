package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int COST_PER_LOTTO = 1000;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int calculateTotalCost() {
        int lottoCount = lottos.size();
        return lottoCount * COST_PER_LOTTO;
    }
}
