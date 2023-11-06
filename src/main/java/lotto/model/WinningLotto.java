package lotto.model;

import lotto.constant.LottoPrize;
import lotto.model.validator.WinningLottoValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        WinningLottoValidator.getInstance().validate(this);
    }

    public LottoPrize match(Lotto lotto) {
        return LottoPrize.valueOf(
                lotto.matchedCount(this.lotto),
                lotto.contains(this.bonusNumber)
        );
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}