package lotto.controller;

import lotto.model.Initializer;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningsInitController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Initializer initializer = new Initializer();

    public Lotto initWinningLotto() {
        try {
            outputView.requestWinningNumbers();
            String userInput = inputView.getUserInput();
            return initializer.initWinningLotto(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return initWinningLotto();
        }
    }

    public int initBonusNumber(Lotto winningLotto) {
        try {
            outputView.requestBonusNumber();
            String userInput = inputView.getUserInput();
            return initializer.initBonusNumber(userInput, winningLotto);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return initBonusNumber(winningLotto);
        }
    }
}