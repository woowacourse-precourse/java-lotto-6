package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.ResultLotto;
import lotto.model.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private UserLotto userLotto;
    private ResultLotto resultLotto;

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

    public void makeResultLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.readWinningNumbers();
                Lotto winningLotto = new Lotto(winningNumbers);
                int bonusNum = inputView.readBonusNum();
                resultLotto = new ResultLotto(winningNumbers,bonusNum);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
