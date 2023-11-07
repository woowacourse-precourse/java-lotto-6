package lotto.util.validation;

import lotto.util.ErrorThrower;

import static lotto.config.ErrorMessage.NOT_THOUSAND_DIVIDED_ERROR;
import static lotto.config.ErrorMessage.PURCHASE_ONLY_NUMBER_ERROR;
import static lotto.config.LottoConfig.LOTTO_NO_REMAIN;
import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.RegexPattern.ONLY_NUMBER_REGEX_PATTERN;

public class LottoPurchaseValidation {

    public void validatorPurchaseOnlyNumber(String purchase) {

        if (!purchase.matches(ONLY_NUMBER_REGEX_PATTERN.getPattern())) {
            ErrorThrower.throwIllegalArgumentException(PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }

    }

    public void validatorNotDivided(String purchase) {

        int purchaseAmount = Integer.parseInt(purchase);

        if (purchaseAmount % LOTTO_PRICE.getValue() != LOTTO_NO_REMAIN.getValue()) {
            ErrorThrower.throwIllegalArgumentException(NOT_THOUSAND_DIVIDED_ERROR.getMessage());
        }

    }

}
