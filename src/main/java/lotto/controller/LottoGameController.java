package lotto.controller;

import lotto.domain.LottoDispenser;
import lotto.domain.Lottos;
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

    private Lottos issueLottos(Money money) {
        return LottoDispenser.issueLottos(money);
    }
}
