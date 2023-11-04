package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResultCalculator;
import lotto.domain.ProfitCalculator;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;


    public LottoController() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService(lottoNumberGenerator);
    }

    public void playLotto() {
        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottos = lottoService.buyLottos(purchaseAmount);
        printLottos(lottos);

        String winningNumbersInput = readWinningNumbersInput();
        int bonusNumber = readBonusNumberInput();
        WinningNumbers winningNumbers = createWinningNumbers(winningNumbersInput, bonusNumber);

        LottoResultCalculator resultCalculator = new LottoResultCalculator(winningNumbers);
        Map<Rank, Integer> results = resultCalculator.calculateResults(lottos);
        outputView.printResults(results);

        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profitRate = profitCalculator.calculateProfitRate(purchaseAmount, results);
        outputView.printProfitRate(profitRate);
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printNumberOfLottosPurchased(lottos.size());
        outputView.printLottos(lottos);
    }

    private String readWinningNumbersInput() {
        return inputView.readWinningNumbers();
    }

    private int readBonusNumberInput() {
        return inputView.readBonusNumber();
    }

    private WinningNumbers createWinningNumbers(String winningNumbersInput, int bonusNumber) {
        return new WinningNumbers(winningNumbersInput, bonusNumber);
    }
}
