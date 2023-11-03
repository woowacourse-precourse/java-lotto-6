package lotto.controller;

import lotto.domain.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView = new InputView();

    public void run() {

        String purchaseAmount = inputView.inputPurchaseAmount();

        Tickets tickets = Tickets.of(purchaseAmount);

        OutputView.printPurchaseNumber(tickets.getNumberOfTickets());

    }
}
