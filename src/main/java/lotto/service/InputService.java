package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.view.InputView;

public class InputService {
    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public Money inputMoney() {
        int number = inputView.inputNumber();
        return new Money(number);
    }

    public List<Integer> inputWinningNumbers() {
        return inputView.inputNumbers();
    }
}
