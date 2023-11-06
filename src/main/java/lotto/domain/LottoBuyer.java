package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private final List<Lotto> lottos;

    public LottoBuyer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
