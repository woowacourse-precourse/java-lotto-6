package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottos;

    private LottoBundle(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoBundle create(final List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
