package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.Revenue;
import lotto.model.WinningLotto;
import lotto.service.Calculator;
import lotto.service.LottoIssuer;
import lotto.service.PrizeCalculator;
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
        List<Lotto> boughtLotto = buyLotto(amount);
        outputView.printBoughtLotto(boughtLotto);
        WinningLotto winningLotto = inputController.getWinningLotto(inputView, outputView);
        List<Rank> winners = collectWinners(boughtLotto, winningLotto);
        Result result = Result.from(winners);
        outputView.printWinningStatistics(result);
        Revenue revenue = calculate(winners, amount);
        outputView.printTotalReturn(revenue);
    }

    private List<Lotto> buyLotto(PurchaseAmount amount) {
        LottoIssuer lottoIssuer = LottoIssuer.of(amount);
        return lottoIssuer.issueLotto();
    }

    private Revenue calculate(List<Rank> ranks, PurchaseAmount amount) {
        Calculator<Revenue> calculator = new PrizeCalculator();
        Long prizes = Rank.sum(ranks);
        Long investmentCost = Long.valueOf(amount.getAmount());
        return calculator.calculate(prizes, investmentCost);
    }

    private List<Rank> collectWinners(List<Lotto> boughtLotto, WinningLotto winningLotto) {
        return boughtLotto.stream()
                .map(winningLotto::getRank)
                .filter(Objects::nonNull)
                .toList();
    }
}
