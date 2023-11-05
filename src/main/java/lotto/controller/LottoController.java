package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.Calculator;
import lotto.service.LottoIssuer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Objects;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;

    public LottoController(InputView inputView, OutputView outputView, InputController inputController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputController = inputController;
    }

    public void run() {
        PurchaseAmount amount = inputController.getPurchaseAmount(inputView, outputView);
        LottoIssuer lottoIssuer = LottoIssuer.of(amount);
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();
        outputView.printBoughtLotto(boughtLotto);
        WinningLotto winningLotto = inputController.getWinningLotto(inputView, outputView);
        List<LottoPrize> lottoPrizes = collectWinners(boughtLotto, winningLotto);
        Result result = Result.from(lottoPrizes);
        outputView.printWinningStatistics(result);
        Double totalReturn = calculate(lottoPrizes, amount);
        outputView.printTotalReturn(totalReturn);
    }

    private Double calculate(List<LottoPrize> lottoPrizes, PurchaseAmount amount) {
        Calculator calculator = new Calculator();
        return calculator.calculatePrize(lottoPrizes, amount);
    }

    private List<LottoPrize> collectWinners(List<Lotto> boughtLotto, WinningLotto winningLotto) {
        return boughtLotto.stream()
                .map(winningLotto::compare)
                .filter(Objects::nonNull)
                .toList();
    }
}
