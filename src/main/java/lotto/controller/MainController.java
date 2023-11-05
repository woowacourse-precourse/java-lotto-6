package lotto.controller;

import java.util.List;
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
        final int amount = inputView.inputBuyAmount();
        final UserLotto userLotto = new UserLotto(userLottoController.buyLotto(amount));
        outputView.printUserLotto(userLotto.getMyLotto());

        final List<Integer> winningNumber = inputView.inputWinningNumber();
        final int bonusNumber = inputView.inputBonusNumber();
    }
}
