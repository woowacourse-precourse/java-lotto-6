package lotto.domain.player;

import lotto.domain.player.lotto.Lotto;

public class PlayerLotto {

    private Lotto lottoNubmers;
    private BonusNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    public PlayerLotto(Lotto lottoNubmers, BonusNumber bonusNumber, PurchaseAmount purchaseAmount) {
        this.lottoNubmers = lottoNubmers;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
    }
}
