package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class PlayerLotto {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    public PlayerLotto(Lotto lotto, LottoNumber bonusNumber, PurchaseAmount purchaseAmount) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
    }
}
