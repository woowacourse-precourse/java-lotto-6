package lotto.controller;

import static lotto.constants.LottoConstants.BONUS_CHALLENGE;

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

    private void purchaseLotto() {
        OutputView.requestPurchaseAmount();
        registerPurchaseAmount();
        OutputView.outputEmptyLine();
    }

    private void registerPurchaseAmount() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        this.lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount);
    }

    private void showPurchaseResult() {
        OutputView.outputPurchaseCount(lottoPurchaseInfo.getPurchaseLottoCount());
        showPurchaseLottos();
        OutputView.outputEmptyLine();
    }

    private void showPurchaseLottos() {
        for (Lotto lotto : lottoPurchaseInfo.getLottos()) {
            OutputView.outputPurchaseLottos(lotto.getNumbers().toString());
        }
    }

    private void showResult() {
        OutputView.outputResult(profit.getWinningResult());
        OutputView.outputProfitRatio(profit.getProfitRatio());
    }

    private void registerWinningLotto() {
        List<Integer> winningNum = getWinningNum();
        OutputView.outputEmptyLine();

        int bonusNum = getBonusNum(winningNum);
        OutputView.outputEmptyLine();

        this.winningLotto = new WinningLotto(winningNum, bonusNum);
    }

    private List<Integer> getWinningNum() {
        OutputView.requestWinningNum();
        return InputView.inputWinningNum();
    }

    private int getBonusNum(List<Integer> winningNum) {
        OutputView.requestBonusNum();
        return InputView.inputBonusNum(winningNum);
    }

    private void setResult() {
        calculateProfit();
        RegisterProfit();
    }

    private void calculateProfit() {
        this.profit = new Profit();

        for (Lotto lotto : lottoPurchaseInfo.getLottos()) {
            profit.addResult(calculateMatchStatus(lotto.getNumbers()));
        }
    }

    private WinningDetails calculateMatchStatus(List<Integer> numbers) {
        boolean isMatchedBonus = false;

        int countMatchedNum = winningLotto.countMatchedNum(numbers);
        if (countMatchedNum == BONUS_CHALLENGE) {
            isMatchedBonus = winningLotto.isMatchedBonus(numbers);
        }
        return WinningDetails.calculateResult(countMatchedNum, isMatchedBonus);
    }

    private void RegisterProfit() {
        profit.setTotalProfit();
        profit.setProfitRatio(lottoPurchaseInfo.getPurchaseAmount());
    }
}
