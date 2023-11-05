package lotto.model.domain;

import java.util.Collections;
import java.util.List;
import lotto.model.domain.lotto.Lotto;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottosDTO() {
        return Collections.unmodifiableList(lottos);
    }
}
