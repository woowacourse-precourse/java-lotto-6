package lotto.controller;

import lotto.domain.MoneyManagement;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        amount();
    }

    public void amount() {
        MoneyManagement amount = getAmount();
        outputView.showTickets(amount.getQuantity());
    }

    public MoneyManagement getAmount() {
        outputView.askAmount();
        String purchaseAmount = inputView.read();
        return MoneyManagement.from(purchaseAmount);
    }



}
