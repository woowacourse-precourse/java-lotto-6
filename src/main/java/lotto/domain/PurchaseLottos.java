package lotto.domain;

import lotto.util.LottoNumbersGenerator;

public class PurchaseLottos {
    private PurchasePrice purchasePrice;
    private Lottos lottos;

    public PurchaseLottos(PurchasePrice purchasePrice, LottoNumbersGenerator generator) {
        this.purchasePrice = purchasePrice;
        int count = purchasePrice.getCount();
        this.lottos = Lottos.of(count, generator);
    }

    public String getPurchaseLottos() {
        return lottos.getEachLotto();
    }

    public int getPurchaseCount() {
        return purchasePrice.getCount();
    }
}
