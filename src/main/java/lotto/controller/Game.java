package lotto.controller;

import java.util.List;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    public Game() {

    }

    public void play() {

        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseLottoNum = purchaseAmount / 1000;

        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount, purchaseLottoNum);
        OutputView.outputPurchaseCount(lottoPurchaseInfo.getPurchaseLottoNum());
        OutputView.outputPurchaseLottos(lottoPurchaseInfo.getLottos());

        List<Integer> winningNum = InputView.inputWinningNum();
        int bonusNum = InputView.inputBonusNum();
        WinningLotto winningLotto = new WinningLotto(winningNum, bonusNum);
    }
}
