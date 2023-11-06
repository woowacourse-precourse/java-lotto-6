package lotto.Domain;

import lotto.View.InputView;

public class LottoPurchaseAmount {

    public static int countLottoQuantity() {
        int purchaseAmount = InputView.inputLottoPurchaseAmount()/1000;
        return purchaseAmount;
    }
}
