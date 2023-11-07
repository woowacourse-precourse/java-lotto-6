package lotto.controller;

import lotto.model.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private UserLotto userLotto;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void purchaseLotto() {
        while (true) {
            try {
                int purchaseMoney = inputView.readPurchaseMoney();
                userLotto = new UserLotto(purchaseMoney);
                outputView.printLottoBundle(userLotto.getLottoBundle());
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
