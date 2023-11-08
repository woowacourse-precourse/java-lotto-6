package lotto.service;

import lotto.domain.money.Money;
import lotto.view.InputView;

public class InputService {
    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public Money inputMoney() {
        try {
            int number = inputView.inputNumber();
            return new Money(number);
        } catch (IllegalArgumentException exception) {
            return inputMoney();
        }
    }
}
