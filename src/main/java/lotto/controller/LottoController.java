package lotto.controller;

import lotto.model.Constants;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public final InputView inputView;
    public final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int purchasePrice = inputView.getPurchasePrice();
        int lottoCount = countLotto(purchasePrice);
        outputView.printPurchaseResult(lottoCount);

        UserLotto userLotto = new UserLotto(lottoCount);
        outputView.printUserLotto(userLotto);

        WinningLotto winningLotto = inputView.getWinningLotto();
        System.out.println();
    }

    private int countLotto(int purchasePrice) {
        return purchasePrice / Constants.PURCHASE_UNIT;
    }
}
