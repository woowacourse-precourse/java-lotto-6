package lotto.domain;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;

import java.math.BigDecimal;
import lotto.utils.LottoUtil;

public class LottoLogic {
    private final BigDecimal purchaseAmount;
    private final int bonusNumber;


    public LottoLogic(BigDecimal purchaseAmount, int bonusNumber) {
        validateMultiplesOf(purchaseAmount, BigDecimal.valueOf(1000));
        LottoUtil.validateLottoNum(bonusNumber);
        this.purchaseAmount = purchaseAmount;
        this.bonusNumber = bonusNumber;
    }

    private static void validateMultiplesOf(BigDecimal num, BigDecimal factor) {
        if (num.remainder(factor).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
        }
    }
}
