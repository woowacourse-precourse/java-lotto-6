package lotto.controller;

import lotto.model.Money;
import lotto.model.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    NumberGenerator numberGenerator = new NumberGenerator();

    public void start() {
        Money money = getValidMoneyInput();
        int ticketCount = getTicketCount(money);
        OutputView.printTicketCount(ticketCount);
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

    private int getTicketCount(Money money) {
        int ticketCount = money.calculateTicketCount();
        return ticketCount;
    }
}