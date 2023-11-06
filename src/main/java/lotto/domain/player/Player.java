package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class Player {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    public Player(Lotto lotto, LottoNumber bonusNumber, PurchaseAmount purchaseAmount) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchasedLottoCount() {
        return purchaseAmount.calculatePurchasedLottoCount();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber.getLottoNumber();
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount.getPurchaseAmount();
    }
}
