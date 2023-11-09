package lotto.domain.lotto;

import lotto.domain.lottoManage.PurchaseAmount;

public class PlayerLotto {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    private PlayerLotto(Lotto lotto, LottoNumber bonusNumber, PurchaseAmount purchaseAmount) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
    }

    public static PlayerLotto create(Lotto lotto, LottoNumber bonusNumber, PurchaseAmount purchaseAmount) {
        return new PlayerLotto(lotto, bonusNumber, purchaseAmount);
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
