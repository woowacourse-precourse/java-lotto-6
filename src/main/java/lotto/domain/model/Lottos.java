package lotto.domain.model;

import java.util.List;
import lotto.domain.model.Lotto;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
