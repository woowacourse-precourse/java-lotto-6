package lotto.domain.lotto;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

}
