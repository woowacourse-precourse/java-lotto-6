package lotto.View;

import lotto.Model.Money;
import lotto.Util.Rule;

public class OutputBuyLottoCount {

    public static void printBuyLotto(Money money) {
        System.out.printf((Rule.OUTPUTLOTTOCOUNT_MESSAGE) + "%n", money.getLotto());
    }
}
