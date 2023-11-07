package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private Money inputLottoPurchaseMoney() {
        try {
            return new Money(InputView.inputLottoPurchaseMoney());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printExceptionMessage(illegalArgumentException);
            return inputLottoPurchaseMoney();
        }
    }
}
