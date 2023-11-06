package lotto.controller;

import lotto.constant.ErrorMessages;
import lotto.domain.*;
import lotto.template.BonusNumberOperation;
import lotto.template.PurchaseLottoOperation;
import lotto.template.TryCatchTemplate;
import lotto.template.WinningNumberOperation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {
    public void run() {
        TryCatchTemplate<PurchaseLotto> purchaseTryCatchTemplate = new TryCatchTemplate<>();
        PurchaseLotto purchaseLottoAmount = purchaseTryCatchTemplate.execute(new PurchaseLottoOperation());

        LottoMachine lottoPapers = buyLotto(purchaseLottoAmount);
        OutputView.displayLottoPapers(lottoPapers);

        TryCatchTemplate<WinningNumber> winningNumberTemplate = new TryCatchTemplate<>();
        WinningNumber winningNumber = winningNumberTemplate.execute(new WinningNumberOperation());

        TryCatchTemplate<BonusNumber> bonusNumberTemplate = new TryCatchTemplate<>();
        BonusNumber bonusNumber = bonusNumberTemplate.execute(new BonusNumberOperation(winningNumber));

        LottoResult lottoResult = createLottoResult(lottoPapers, winningNumber, bonusNumber);
        double profitMargin = totalProfitMargin(lottoResult, purchaseLottoAmount);
        OutputView.displayResults(lottoResult);
        OutputView.displayProfitMargin(profitMargin);
    }

    private LottoMachine buyLotto(PurchaseLotto purchaseLottoAmount) {
        int lottoPaperAmount = purchaseLottoAmount.calculateLottoCount();
        OutputView.purchaseCount(lottoPaperAmount);
        return new LottoMachine(lottoPaperAmount);
    }

    private double totalProfitMargin(LottoResult lottoResult, PurchaseLotto purchaseLottoAmount) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        int profit = profitCalculator.calculateProfit(lottoResult);
        return profitCalculator.calculateProfitMargin(profit, purchaseLottoAmount.getPurchaseAmount());
    }

    private LottoResult createLottoResult(LottoMachine lottoPapers, WinningNumber winNum, BonusNumber bonusNum) {
        LotteryChecker lotteryChecker = new LotteryChecker(lottoPapers);
        return lotteryChecker.calculateRank(winNum, bonusNum);
    }
}
