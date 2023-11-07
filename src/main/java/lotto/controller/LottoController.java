package lotto.controller;

import lotto.domain.*;
import lotto.template.*;
import lotto.view.OutputView;

import static lotto.domain.LottoMachine.buyLotto;
import static lotto.domain.LottoResult.createLottoResult;
import static lotto.domain.ProfitCalculator.totalProfitMargin;


public class LottoController {
    private PurchaseLotto purchaseLottoAmount;
    private LottoMachine lottoPapers;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private LottoResult lottoResult;
    private double profitMargin;

    public void run() {
        buyLottoLogic();
        createWinningAndBonusNumber();
        calculateLottoResult();
        printLottoResult();
    }

    private void buyLottoLogic() {
        this.purchaseLottoAmount = executeWithTryCatch(new PurchaseLottoOperation());
        this.lottoPapers = buyLotto(purchaseLottoAmount);
        OutputView.displayLottoPapers(lottoPapers);
    }

    private void createWinningAndBonusNumber() {
        this.winningNumber = executeWithTryCatch(new WinningNumberOperation());
        this.bonusNumber = executeWithTryCatch(new BonusNumberOperation(winningNumber));
    }

    private <T> T executeWithTryCatch(Operation<T> operation) {
        TryCatchTemplate<T> template = new TryCatchTemplate<>();
        return template.execute(operation);
    }

    private void calculateLottoResult() {
        this.lottoResult = createLottoResult(lottoPapers, winningNumber, bonusNumber);
        this.profitMargin = totalProfitMargin(lottoResult, purchaseLottoAmount);
    }

    private void printLottoResult() {
        OutputView.displayResults(lottoResult);
        OutputView.displayProfitMargin(profitMargin);
    }
}
