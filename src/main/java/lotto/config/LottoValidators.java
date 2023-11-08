package lotto.config;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class LottoValidators {
    public final PurchaseAmountValidator purchaseAmountValidator;
    public final WinningLottoValidator winningLottoValidator;
    public final BonusNumberValidator bonusNumberValidator;


    public LottoValidators(PurchaseAmountValidator purchaseAmountValidator, WinningLottoValidator winningLottoValidator,
                           BonusNumberValidator bonusNumberValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winningLottoValidator = winningLottoValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }
}
