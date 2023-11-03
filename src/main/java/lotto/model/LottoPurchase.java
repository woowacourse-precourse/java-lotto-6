package lotto.model;

import lotto.util.CommonValidation;
import lotto.util.Constants;
import lotto.view.OutputView;

public class LottoPurchase {
    private final int lottoCount;

    private LottoPurchase(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoPurchase purchaseLotto(String amount) {
        CommonValidation.validate(amount);
        return new LottoPurchase(Integer.parseInt(amount) / Constants.DIVISION_VALUE);
    }

    public int getLottoCount(){
        return this.lottoCount;
    }
}
