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

    public void start() {
        purchaseLotto();
        makeResultLotto();
        result();
    }

    private void purchaseLotto() {
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

    private void makeResultLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.readWinningNumbers();
                Lotto winningLotto = new Lotto(winningNumbers);
                checkBonusNum(winningNumbers);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void checkBonusNum(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNum = inputView.readBonusNum();
                resultLotto = new ResultLotto(winningNumbers,bonusNum);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void result() {
        List<Lotto> userLottoBundle = userLotto.getLottoBundle();
        List<Integer> winning = resultLotto.calculateResult(userLottoBundle);
        outputView.printWinning(winning, userLottoBundle.size() * 1000);
    }
}
