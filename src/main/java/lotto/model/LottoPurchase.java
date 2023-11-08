package lotto.model;

import lotto.util.CommonValidation;
import lotto.util.Constants;
import lotto.util.PurchaseAmountValidation;
import java.util.List;

public class LottoPurchase {
    private final List<Integer> userLotto;

    private LottoPurchase(final List<Integer> userLotto) {
        this.userLotto = userLotto;
    }
    public static int purchaseLottery(final String amount) {
        CommonValidation.validate(amount);
        PurchaseAmountValidation.divisibleThousand(amount);
        return Integer.parseInt(amount) / Constants.DIVISION_VALUE;
    }
    public static LottoPurchase userLotteryFrom (final List<Integer> randomNumbers) {
        return new LottoPurchase(randomNumbers);
    }

    public List<Integer> getUserLottery() {
        return this.userLotto;
    }
}
