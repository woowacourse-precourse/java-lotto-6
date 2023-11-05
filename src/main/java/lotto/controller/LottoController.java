package lotto.controller;

import lotto.domain.Money;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        Money money = getMoney();

    }

    private Money getMoney() {
        while (true) {
            try {
                outputView.printGetMoney();
                int number = inputView.getNumber();
                return new Money(number);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

}
