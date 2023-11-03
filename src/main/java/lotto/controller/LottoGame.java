package lotto.controller;

import lotto.domain.Money;
import lotto.util.LottoGuideMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Money money = createMoneyFromUserInput();
    }

    private Money createMoneyFromUserInput() {
        outputView.showMessage(LottoGuideMessage.ENTER_PURCHASE_AMOUNT);
        return new Money(inputView.getUserInput());
    }
}
