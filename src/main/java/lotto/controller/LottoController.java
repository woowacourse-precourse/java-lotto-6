package lotto.controller;

import lotto.view.OutputView;

public class LottoController {
    public void run() {
        setTicketAmountAndCount();
    }

    private void setTicketAmountAndCount() {
        OutputView.printMoneyInputMessage();
    }
}