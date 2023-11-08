package lotto.model;

import lotto.Lotto;
import lotto.manager.InputManager;
import lotto.manager.OutputManager;

import java.util.List;

public class LottoGame {
    InputManager inputManager;
    OutputManager outputManager;
    Lottos lottos;
    List<Integer> matchCounts;
    int inputCost;

    public LottoGame() {
        inputManager = new InputManager();
        outputManager = new OutputManager();
    }

    public void lottoGame() {
        createLottos();
        createWinningNumbers();
        createResult();
    }

    private void createLottos() {
        inputCost = inputManager.inputLottoCost();

        lottos = new Lottos(inputCost);
        lottos.createLottos();

        outputManager.printLottos(lottos);
    }

    private void createWinningNumbers() {
        List<Integer> winningNumbers = inputManager.inputWinningNumbers();
        int bonusNumber = inputManager.inputBonusNumber(winningNumbers);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new Lotto(winningNumbers), bonusNumber);
        matchCounts = lottoWinningNumbers.correctNumberCheckerForMultipleLottos(lottos);
    }

    private void createResult() {
        LottoCalculator lottoCalculator = new LottoCalculator(matchCounts);
        List<Integer> ranks = lottoCalculator.calculateRank();
        double returnResult = lottoCalculator.calculateReturnRate(inputCost);

        outputManager.printResult(ranks, returnResult);
    }
}
