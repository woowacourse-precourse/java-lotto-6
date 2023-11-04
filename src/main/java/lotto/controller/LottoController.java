package lotto.controller;

import lotto.domain.Tickets;

public class LottoController {

    public void gernerateTicket(final int wallet) {
        Tickets tickets = Tickets.from(wallet);
        tickets.generate();
    }

    public void drawNumber() {

    }

    public void verifyWinRecord() {

    }

    public void verifyReturns() {

    }

}
