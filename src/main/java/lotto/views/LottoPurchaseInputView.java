package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.StringConstants;
import lotto.domain.LottoPurchase;
import lotto.utils.StringUtils;

public class LottoPurchaseInputView implements View<LottoPurchase> {
    @Override
    public LottoPurchase render() {
        System.out.println(StringConstants.INPUT_BUY_PRICE);
        var rawBuyPrice = Console.readLine();
        var buyPrice = StringUtils.parseInt(rawBuyPrice);
        return new LottoPurchase(buyPrice);
    }

}
