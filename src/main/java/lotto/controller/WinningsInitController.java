package lotto.controller;

import lotto.model.WinningsInitializer;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningsInitController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final WinningsInitializer winningsInitializer = new WinningsInitializer();

    public Lotto initWinningLotto() {
        try {
            outputView.requestWinningNumbers();
            String userInput = inputView.getUserInput();
            return winningsInitializer.initWinningLotto(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return initWinningLotto();
        }
    }

    public int initBonusNumber(Lotto winningLotto) {
        try {
            outputView.requestBonusNumber();
            String userInput = inputView.getUserInput();
            return winningsInitializer.initBonusNumber(userInput, winningLotto);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return initBonusNumber(winningLotto);
        }
    }
}