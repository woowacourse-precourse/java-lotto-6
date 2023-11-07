package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Money money = createMoneyInput();

    }

    public Money createMoneyInput() {
        outputView.printMoneyInput();
        while (true) {
            try {
                String inputMoney = inputView.moneyInput();
                return new Money(inputMoney);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }


    }
}
