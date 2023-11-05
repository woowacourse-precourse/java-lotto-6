package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void start() {
        OutputView.printMoneyInputMessage();
        long moneyAmount = InputView.nextLong();
        Money money = new Money(moneyAmount);
        OutputView.printBuyInfoMessage(money.getDivideValue());
        
    }
}
