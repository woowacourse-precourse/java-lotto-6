package lotto.domain;

import lotto.util.validation.LottoPurchaseValidation;
import lotto.util.validation.LottoValidation;

public class LottoPurchase {

    LottoPurchaseValidation purchaseValidator = new LottoPurchaseValidation();
    LottoValidation validator = new LottoValidation();

    public int lottoPurchaseCount(String input) {

        int purchaseAmount = Integer.parseInt(input);

        try {
            validator.validatorOnlyNumber(input);
            purchaseValidator.validatorNotDivided(purchaseAmount);
        } catch (IllegalArgumentException e) {
            lottoPurchaseCount(input);
        }

        purchaseAmount /= 1000;

        return purchaseAmount;
    }

}
