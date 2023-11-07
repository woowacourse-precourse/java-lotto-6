package lotto.domain.result;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Purchase;

public class PurchaseResult {
    private final List<Lotto> lottos;
    private final Purchase purchase;

    public PurchaseResult(List<Lotto> lottos, Purchase purchase) {
        this.lottos = lottos;
        this.purchase = purchase;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
