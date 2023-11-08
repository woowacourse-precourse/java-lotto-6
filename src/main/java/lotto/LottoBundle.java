package lotto;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
