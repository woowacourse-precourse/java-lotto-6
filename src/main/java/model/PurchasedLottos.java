package model;

import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
