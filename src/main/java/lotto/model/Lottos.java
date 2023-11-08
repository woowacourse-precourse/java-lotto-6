package lotto.model;

import java.util.List;
public class Lottos {
    private final List<Lotto> lottos;
    private final int buyAmount;

    public Lottos(List<Lotto> lottos, int buyAmount) {
        this.lottos = lottos;
        this.buyAmount = buyAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBuyAmount() {
        return buyAmount;
    }
}
