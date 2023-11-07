package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoContainer;

    public Lottos(List<Lotto> lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    public void addLotto(Lotto lotto) {
        lottoContainer.add(lotto);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottoContainer);
    }
}
