package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private int purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();

    public void buyLotto(int purchaseAmount, List<Lotto> lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
