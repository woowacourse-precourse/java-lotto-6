package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.Calculator;
import lotto.service.PrizeCalculator;
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
        List<Lotto> boughtLotto = buyLotto(amount);
        outputView.printBoughtLotto(boughtLotto);
        WinningLotto winningLotto = inputController.getWinningLotto(inputView, outputView);
        List<Rank> winners = collectWinners(boughtLotto, winningLotto);
        Result result = Result.from(winners);
        outputView.printWinningStatistics(result);
        Double totalReturn = calculate(winners, amount);
        outputView.printTotalReturn(totalReturn);
    }

    private List<Lotto> buyLotto(PurchaseAmount amount) {
        LottoIssuer lottoIssuer = LottoIssuer.of(amount);
        return lottoIssuer.issueLotto();
    }

    private Double calculate(List<Rank> ranks, PurchaseAmount amount) {
        Calculator prizeCalculator = new PrizeCalculator();
        Long revenue = Rank.sum(ranks);
        Long investmentCost = Long.valueOf(amount.getAmount());
        return prizeCalculator.calculate(revenue, investmentCost);
    }

    private List<Rank> collectWinners(List<Lotto> boughtLotto, WinningLotto winningLotto) {
        return boughtLotto.stream()
                .map(winningLotto::getRank)
                .filter(Objects::nonNull)
                .toList();
    }
}
