package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.util.LottoUtil;
import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(String inputAmount) {
        PurchaseAmountValidator.validate(inputAmount);
        this.purchaseAmount = LottoUtil.parseInputToNumber(inputAmount);
    }

    public boolean isNotFullyIssued(int count) {
        return purchaseAmount / LOTTO_PRICE != count;
    }

}
