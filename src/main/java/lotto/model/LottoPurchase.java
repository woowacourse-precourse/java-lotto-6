package lotto.model;

import lotto.util.CommonValidation;
import lotto.util.Constants;
import lotto.util.PurchaseAmountValidation;
import java.util.List;

public class LottoPurchase {
    private final List<Integer> userLotto;

    private LottoPurchase(List<Integer> userLotto) {
        this.userLotto = userLotto;
    }
    public static int purchaseLottery(String amount) {
        CommonValidation.validate(String.valueOf(amount));
        PurchaseAmountValidation.divisibleThousand(amount);
        return Integer.parseInt(amount) / Constants.DIVISION_VALUE;
    }
}
