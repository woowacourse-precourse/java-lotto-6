package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> purchaseLottos;

    public Lottos(List<Lotto> purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public List<Lotto> getPurchaseLottos() {
        return Collections.unmodifiableList(purchaseLottos);
    }
}
