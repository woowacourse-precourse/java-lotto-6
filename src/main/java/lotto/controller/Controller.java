package lotto.controller;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.CreateStrategy;
import lotto.service.Service;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Controller {

    private final Service service;
    private final InputView inputView;
    private final OutputView outputView;
    private final CreateStrategy createStrategy;

    public Controller(final Service service,
                      final InputView inputView,
                      final OutputView outputView,
                      final CreateStrategy createStrategy) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
        this.createStrategy = createStrategy;
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
        final Lottos lottos = new Lottos(count, this.createStrategy);
        outputView.printPurchasedLottosMessage(count);
        outputView.printLottosStatus(lottos.getLottosStatus());
    }
}
