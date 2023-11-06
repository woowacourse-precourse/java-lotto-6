package lotto.domain.player;

import lotto.domain.player.lotto.Lotto;

public class PlayerLotto {

    private Lotto lotto;
    private BonusNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    public PlayerLotto(Lotto lotto, BonusNumber bonusNumber, PurchaseAmount purchaseAmount) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
    }
}
