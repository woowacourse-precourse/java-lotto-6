package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.Calculator;
import lotto.service.LottoIssuer;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final OutputView outputView;
    private final InputController exceptionController;


    public LottoController(OutputView outputView, InputController inputController) {
        this.outputView = outputView;
        this.exceptionController = inputController;
    }

    public void run() {
        PurchaseAmount amount = exceptionController.getPurchaseAmount();
        LottoIssuer lottoIssuer = LottoIssuer.of(amount);
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();
        outputView.printBoughtLotto(boughtLotto);
        WinningLotto winningLotto = exceptionController.getWinningLotto();
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto bought : boughtLotto) {
            lottoPrizes.add(winningLotto.compare(bought));
        }
        Result result = Result.from(lottoPrizes);
        outputView.printWinningStatistics(result);
        Calculator calculator = new Calculator();
        Double totalReturn = calculator.calculatePrize(lottoPrizes);
        outputView.printTotalReturn(totalReturn);
    }
}
