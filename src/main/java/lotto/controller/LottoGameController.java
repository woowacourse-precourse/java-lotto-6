package lotto.controller;

import lotto.exception.EmptyInputException;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void game() {
        inputUserMoneyAmount();
    }

    private void inputUserMoneyAmount() {
        String money = inputView.inputMoneyAmount();
    }
}
