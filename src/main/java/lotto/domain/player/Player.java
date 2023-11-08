package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
public class Player {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    private Player(Lotto lotto, LottoNumber bonusNumber, PurchaseAmount purchaseAmount) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
    }

    public static Player create(Lotto lotto, LottoNumber bonusNumber, PurchaseAmount purchaseAmount) {
        return new Player(lotto, bonusNumber, purchaseAmount);
    }

    public int getPurchasedLottoCount() {
        return purchaseAmount.calculatePurchasedLottoCount(purchaseAmount);
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
