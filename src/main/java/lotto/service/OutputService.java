package lotto.service;

import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.view.OutputView;

public class OutputService {
    private final OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void purchaseAmount() {
        outputView.purchaseAmount();
    }

    public void lottos(Money money, Lottos lottos) {
        outputView.lottos(money.ticketCount(), lottos.printLottos());
    }

    public void winningNumbers() {
        outputView.winningNumbers();
    }

    public void bonusNumber() {
        outputView.bonusNumber();
    }

    public void handleException(IllegalArgumentException exception) {
        outputView.printExceptionMessage(exception.getMessage());
    }
}
