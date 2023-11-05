package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validation.LottoPurchaseValidation;
import lotto.util.validation.LottoValidation;
import lotto.view.InputView;

public class LottoPurchase {

    LottoPurchaseValidation purchaseValidator = new LottoPurchaseValidation();

    public int lottoPurchaseCount(String input) {

        lottoPurchaseValidation(input);

        int purchaseAmount = Integer.parseInt(input);

        purchaseAmount /= 1000;

        return purchaseAmount;
    }

    public void lottoPurchaseValidation(String input) {
        purchaseValidator.validatorPurchaseOnlyNumber(input);
        purchaseValidator.validatorNotDivided(input);
    }

}
