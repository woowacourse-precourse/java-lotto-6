package lotto.controller;

import lotto.domain.amount.Amount;
import lotto.service.Service;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Controller {

    private final Service service;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final Service service,
                      final InputView inputView,
                      final OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Amount amount = initAmount();
        announcePurchasedLottos(amount.getCount());
    }

    private Amount initAmount() {
        return ExceptionHandler.handle(() -> {
            final int amount = inputView.readAmount();
            return new Amount(amount);
        });
    }

    private void announcePurchasedLottos(final int count) {
        outputView.printPurchasedLottosMessage(count);
    }

}
