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
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);
        printLottos(lottos);

        WinningNumbers winningNumbers = getWinningNumbers();
        Map<Rank, Integer> results = calculateLottoResults(lottos, winningNumbers);
        printResults(results);

        double profitRate = calculateProfitRate(purchaseAmount, results);
        printProfitRate(profitRate);
    }

    private int getPurchaseAmount() {
        return inputView.getPurchaseAmount();
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        return lottoService.buyLottos(purchaseAmount);
    }

    private WinningNumbers getWinningNumbers() {
        String winningNumbersInput = getWinningNumbersInput();
        int bonusNumber = getBonusNumberInput();
        return WinningNumbersFactory.createWinningNumbers(winningNumbersInput, bonusNumber);
    }

    private Map<Rank, Integer> calculateLottoResults(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return resultCalculator.calculateResults(lottos, winningNumbers);
    }

    private void printResults(Map<Rank, Integer> results) {
        outputView.printResults(results);
    }

    private double calculateProfitRate(int purchaseAmount, Map<Rank, Integer> results) {
        return profitCalculator.getProfitRate(purchaseAmount, results);
    }

    private void printProfitRate(double profitRate) {
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
}
