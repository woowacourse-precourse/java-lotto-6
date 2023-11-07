package lotto.controller;

import java.util.List;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private LottoPurchaseInfo lottoPurchaseInfo;
    private WinningLotto winningLotto;

    public void play() {
        purchaseLotto();
        showPurchaseResult();
        registerWinningLotto();
    }

    void purchaseLotto() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        this.lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount);
    }

    void showPurchaseResult() {
        OutputView.outputPurchaseCount(lottoPurchaseInfo.getPurchaseLottoCount());
        OutputView.outputPurchaseLottos(lottoPurchaseInfo.getLottos());
    }

    void registerWinningLotto() {
        List<Integer> winningNum = InputView.inputWinningNum();
        int bonusNum = InputView.inputBonusNum();
        this.winningLotto = new WinningLotto(winningNum, bonusNum);
    }
}
