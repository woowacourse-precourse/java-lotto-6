package lotto.controller;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private InputView inputView;
    private OutputView outputView;
    private User user;

    public LottoGame(InputView inputView, OutputView outputView, User user) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.user = user;
    }

    public void start() {
        user.setPurchaseAmount(inputView.purchaseAmount());
    }
}
