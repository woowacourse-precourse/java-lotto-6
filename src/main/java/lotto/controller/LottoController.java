package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResultCalculator;
import lotto.domain.ProfitCalculator;
import lotto.Constant.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningNumbersFactory;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoResultCalculator resultCalculator;
    private final ProfitCalculator profitCalculator;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoService lottoService,
                           LottoResultCalculator resultCalculator,
                           ProfitCalculator profitCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.resultCalculator = resultCalculator;
        this.profitCalculator = profitCalculator;
    }

    public void playLotto() {
        int purchaseAmount = inputView.getPurchaseAmount();
        List<Lotto> lottos = lottoService.buyLottos(purchaseAmount);
        printLottos(lottos);

        String winningNumbersInput = getWinningNumbersInput();
        int bonusNumber = getBonusNumberInput();
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(winningNumbersInput, bonusNumber);

        Map<Rank, Integer> results = resultCalculator.calculateResults(lottos, winningNumbers);
        outputView.printResults(results);

        double profitRate = profitCalculator.getProfitRate(purchaseAmount, results);
        outputView.printProfitRate(profitRate);
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printPurchasedLottoQuantity(lottos.size());
        outputView.printLottos(lottos);
    }

    private String getWinningNumbersInput() {
        return inputView.getWinningNumbers();
    }

    private int getBonusNumberInput() {
        return inputView.getBonusNumber();
    }

    private WinningNumbers createWinningNumbers(String winningNumbersInput, int bonusNumber) {
        return new WinningNumbers(winningNumbersInput, bonusNumber);
    }
}
