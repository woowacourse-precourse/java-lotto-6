package lotto.Controller;

import java.util.List;
import lotto.Model.Lotto;
import lotto.View.InputView;

public class LottoGame {

    private static int countLottoQuantity() {

        int purchaseAmount = InputView.inputLottoPurchaseAmount() / 1000;

        return purchaseAmount;
    }

}
