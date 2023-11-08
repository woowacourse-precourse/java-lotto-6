package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(lottos);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
