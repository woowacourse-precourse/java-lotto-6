package lotto.controller;

import static lotto.util.ConstantMessages.DEPOSIT_TICKET_MONEY;
import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

import lotto.exception.LottoException;
import lotto.model.Money;

public class LottoController {
    public void run() {
        printMessage(DEPOSIT_TICKET_MONEY.getMessage());
        Money money = initMoney();


    }

    public Money initMoney() {
        String input = inputTicketQuantity();
        try {
            Money.of(input);
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            initMoney();
        }

        return Money.of(input);
    }
}
