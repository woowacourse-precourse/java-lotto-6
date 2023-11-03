package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> lottos;

    public PurchasedLotto() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
