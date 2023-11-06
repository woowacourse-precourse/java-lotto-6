package lotto.domain;

import java.util.List;

public class Customer {
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;

    public Customer(LottoShop lottoShop, long purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        this.lottos = lottoShop.purchase(this.purchaseAmount);
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
