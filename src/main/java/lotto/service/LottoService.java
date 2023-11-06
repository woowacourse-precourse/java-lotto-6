package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;

public class LottoService {
    private PurchasedLottos purchasedLottos;

    public PurchasedLottos getPurchasedLottos(PurchaseAmount purchaseAmount) {
        this.purchasedLottos = new PurchasedLottos(purchaseAmount);
        return this.purchasedLottos;
    }
}
