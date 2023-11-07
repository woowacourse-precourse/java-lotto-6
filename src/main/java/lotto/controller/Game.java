package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.Profit;
import lotto.domain.WinningDetails;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private LottoPurchaseInfo lottoPurchaseInfo;
    private WinningLotto winningLotto;
    private Profit profit;

    public void play() {
        purchaseLotto();
        showPurchaseResult();
        registerWinningLotto();
        calculateResult();
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

    void calculateResult() {
        calculateWinningResult();
        RegisterProfit();
    }

    void calculateWinningResult() {
        this.profit = new Profit();

        int countMatchedNum = 0;
        boolean isMatchedBonus = false;
        
        for (Lotto lotto : lottoPurchaseInfo.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            countMatchedNum = winningLotto.countMatchedNum(numbers);
            if (countMatchedNum == 5) {
                isMatchedBonus = winningLotto.isMatchedBonus(numbers);
            }
            profit.addResult(WinningDetails.calculateResult(countMatchedNum, isMatchedBonus));
        }
    }

    void RegisterProfit() {

    }
}
