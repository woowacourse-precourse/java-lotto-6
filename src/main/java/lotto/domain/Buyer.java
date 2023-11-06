package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final List<Lotto> lottos = new ArrayList<>();

    public void buyLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return lottos.size() * Lotto.PRICE;
    }
}
