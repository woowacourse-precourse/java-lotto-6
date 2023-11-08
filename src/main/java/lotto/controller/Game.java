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
        setResult();
        showResult();
    }

    void purchaseLotto() {
        OutputView.requestPurchaseAmount();
        registerPurchaseAmount();
    }

    void registerPurchaseAmount() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        this.lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount);
    }

    void showPurchaseResult() {
        OutputView.outputPurchaseCount(lottoPurchaseInfo.getPurchaseLottoCount());
        showPurchaseLottos();
    }

    void showPurchaseLottos() {
        for (Lotto lotto : lottoPurchaseInfo.getLottos()) {
            OutputView.outputPurchaseLottos(lotto.getNumbers().toString());
        }
    }

    void showResult() {
        OutputView.outputResult(profit.getWinningResult());
        OutputView.outputProfitRatio(profit.getProfitRatio());
    }

    void registerWinningLotto() {
        List<Integer> winningNum = getWinningNum();
        int bonusNum = getBonusNum();
        this.winningLotto = new WinningLotto(winningNum, bonusNum);
    }

    List<Integer> getWinningNum() {
        OutputView.requestWinningNum();
        return InputView.inputWinningNum();
    }

    int getBonusNum() {
        OutputView.requestBonusNum();
        return InputView.inputBonusNum();
    }

    void setResult() {
        calculateProfit();
        RegisterProfit();
    }

    void calculateProfit() {
        this.profit = new Profit();

        for (Lotto lotto : lottoPurchaseInfo.getLottos()) {
            profit.addResult(calculateMatchStatus(lotto.getNumbers()));
        }
    }

    WinningDetails calculateMatchStatus(List<Integer> numbers) {
        boolean isMatchedBonus = false;
        int countMatchedNum = winningLotto.countMatchedNum(numbers);
        if (countMatchedNum == 5) {
            isMatchedBonus = winningLotto.isMatchedBonus(numbers);
        }

        return WinningDetails.calculateResult(countMatchedNum, isMatchedBonus);
    }

    void RegisterProfit() {
        profit.setTotalProfit();
        profit.setProfitRatio(lottoPurchaseInfo.getPurchaseAmount());
    }
}
