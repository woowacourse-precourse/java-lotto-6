package lotto.controller;

import lotto.model.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final UserLottoController userLottoController;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        userLottoController = new UserLottoController();
    }

    public void start() {
        // userLottoController 사용
        int amount = inputView.inputBuyAmount();
        UserLotto userLotto = new UserLotto(userLottoController.buyLotto(amount));

    }
}
