package lotto.controller;

import lotto.domain.*;
import lotto.template.*;
import lotto.view.OutputView;

import static lotto.domain.LottoMachine.buyLotto;
import static lotto.domain.LottoResult.createLottoResult;
import static lotto.domain.ProfitCalculator.totalProfitMargin;


public class LottoController {
    public void run() {
        PurchaseLotto purchaseLottoAmount = executeWithTryCatch(new PurchaseLottoOperation());
        LottoMachine lottoPapers = buyLotto(purchaseLottoAmount);
        OutputView.displayLottoPapers(lottoPapers);

        WinningNumber winningNumber = executeWithTryCatch(new WinningNumberOperation());
        BonusNumber bonusNumber = executeWithTryCatch(new BonusNumberOperation(winningNumber));

        LottoResult lottoResult = createLottoResult(lottoPapers, winningNumber, bonusNumber);
        double profitMargin = totalProfitMargin(lottoResult, purchaseLottoAmount);
        OutputView.displayResults(lottoResult);
        OutputView.displayProfitMargin(profitMargin);
    }

    private <T> T executeWithTryCatch(Operation<T> operation) {
        TryCatchTemplate<T> template = new TryCatchTemplate<>();
        return template.execute(operation);
    }
}
