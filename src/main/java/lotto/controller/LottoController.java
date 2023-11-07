package lotto.controller;

import static lotto.view.OutputView.printUserLotto;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningLotto;

public class LottoController {
    private User user;
    private WinningLotto winningLotto;

    public void startGame() {
        setUser();
        setWinningLotto();
    }

    private void setUser() {
        user = InputController.makeUser();
        printUserLotto(user);
    }

    private void setWinningLotto() {
        Lotto winningNumbers = InputController.makeWinningNumbers();
        winningLotto = InputController.makeWinningLotto(winningNumbers);
    }

}
