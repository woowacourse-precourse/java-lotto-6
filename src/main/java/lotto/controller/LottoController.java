package lotto.controller;

import static lotto.view.OutputView.printByLottoCount;

import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printByLottoCount(money);
    }

    private Money getMoney() {
        int money = InputView.getUserInputForLottoBuyAccount();
        return new Money(money);
    }
}
