package lotto.controller;

import java.util.HashSet;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.LottoResultCalculator;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos.size(), lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(new HashSet<>(winningNumbers));

        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);
        LottoResult lottoResult = LottoResultCalculator.calculateResult(lottos, winningNumbersObject);

        OutputView.printResult(lottoResult);

        double winningRate = lottoResult.calculateWinningRate(purchaseAmount);
        OutputView.printWinningRate(winningRate);
    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        return LottoGenerator.generateLottos(purchaseAmount / LottoGenerator.LOTTO_PRICE);
    }
}
