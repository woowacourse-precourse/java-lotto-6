package lotto.controller;

import lotto.domain.Money;
import lotto.view.MoneyInputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        Money money = getMoney();
    }

    private Money getMoney() {
        MoneyInputView moneyInputView = new MoneyInputView();
        while (true) {
            try {
                outputView.printMoneyInputMessage();
                long moneyInput = moneyInputView.readMoneyInput();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

}
