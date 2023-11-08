package lotto.controller;

import static lotto.util.Constants.LOTTO_PRICE;

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
        printPurchasedLottos(lottos);

        WinningNumbers winningNumbersObject = getWinningNumbers();
        LottoResult lottoResult = calculateLottoResult(lottos, winningNumbersObject);

        OutputView.printResult(lottoResult);

        double winningRate = lottoResult.calculateWinningRate(purchaseAmount);
        OutputView.printWinningRate(winningRate);
    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        return LottoGenerator.generateLottos(purchaseAmount / LOTTO_PRICE);
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        OutputView.printLottoNumbers(lottos.size(), lottos);
    }

    private WinningNumbers getWinningNumbers() {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(new HashSet<>(winningNumbers));
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private LottoResult calculateLottoResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return LottoResultCalculator.calculateResult(lottos, winningNumbers);
    }
}
