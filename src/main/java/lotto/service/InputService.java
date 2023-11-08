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

    public int inputMoney() {
        return inputView.inputNumber();
    }

    public List<Integer> inputWinningNumbers() {
        return inputView.inputNumbers();
    }
}
