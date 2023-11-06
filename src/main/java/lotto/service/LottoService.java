package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;

public class LottoService {
    private PurchasedLottos purchasedLottos;
    private Lotto winningLotto;

    public PurchasedLottos getPurchasedLottos(PurchaseAmount purchaseAmount) {
        this.purchasedLottos = new PurchasedLottos(purchaseAmount);
        return this.purchasedLottos;
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto.getLotto();
    }
}
