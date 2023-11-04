package lotto.Domain;

import lotto.View.InputView;
import lotto.View.OutputView;

public class CountLottoAmount {

    public static void countLottoQuantity() {
        int purchaseAmount = InputView.inputLottoPurchaseAmount() / 1000;

        OutputView.printLottoAmount(purchaseAmount);
    }
}
