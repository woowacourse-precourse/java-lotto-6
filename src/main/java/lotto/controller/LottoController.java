package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        Money money = getValidMoneyInput();
        printTicketCountAndOutput(money);
    }

    private Money getValidMoneyInput() {
        Money money = null;
        while (money == null) {
            try {
                money = new Money(InputView.getMoneyInput());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return money;
    }
