package lotto.controller;

import static lotto.view.OutputView.printUserLotto;

import lotto.model.User;
import lotto.model.WinningLotto;

public class LottoController {
    private User user;
    private WinningLotto winningLotto;

    public void startGame() {
        setUser();
    }

    private void setUser() {
        user = InputController.makeUser();
        printUserLotto(user);
    }

}
