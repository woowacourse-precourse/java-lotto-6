package lotto.config;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class LottoValidators {
    public final PurchaseAmountValidator purchaseAmountValidator;
    public final WinningLottoValidator winningLottoValidator;


    public LottoValidators(PurchaseAmountValidator purchaseAmountValidator,
                           WinningLottoValidator winningLottoValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winningLottoValidator = winningLottoValidator;
    }
}
