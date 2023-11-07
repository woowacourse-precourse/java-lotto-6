package lotto.views;

import lotto.constants.StringConstants;
import lotto.domain.LottoPurchase;
import lotto.io.Input;

public class LottoPurchaseInputView implements View<LottoPurchase> {
    @Override
    public LottoPurchase render() {
        System.out.println(StringConstants.INPUT_BUY_PRICE);
        var buyPrice = Input.readLineAsInt();
        return new LottoPurchase(buyPrice);
    }

}
