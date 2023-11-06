package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static Lottos of(final Quantity totalLotteries, final LottoGenerator generator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLotteries.getQuantity(); i++) {
            lottos.add(new Lotto(generator.generate()));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
