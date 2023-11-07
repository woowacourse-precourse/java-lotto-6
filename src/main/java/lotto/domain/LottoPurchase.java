package lotto.domain;

import lotto.util.validation.LottoPurchaseValidation;

import static lotto.config.LottoConfig.LOTTO_PRICE;

public class LottoPurchase {

    LottoPurchaseValidation purchaseValidator = new LottoPurchaseValidation();

    public int lottoPurchaseCount(String input) {

        lottoPurchaseValidation(input);

        int purchaseAmount = Integer.parseInt(input);

        purchaseAmount /= LOTTO_PRICE.getValue();

        return purchaseAmount;
    }

    public void lottoPurchaseValidation(String input) {
        purchaseValidator.validatorPurchaseOnlyNumber(input);
        purchaseValidator.validatorNotDivided(input);
    }

}
