package lotto.model;

import lotto.manager.InputManager;
import lotto.manager.Message;
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
        try {
            inputCost = inputManager.inputInt(Message.LOTTO_COST_MESSAGE.getMessage());

            lottos = new Lottos(inputCost);
            lottos.createLottos();

            outputManager.printLottos(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createLottos();
        }
    }

    private void createWinningNumbers() {
        try {
            List<Integer> winningNumbers = inputManager.inputMultipleInt("\n" + Message.WINNING_NUMBERS_MESSAGE.getMessage());
            Lotto winningLotto = new Lotto(winningNumbers);
            int bonusNumber = inputManager.inputInt("\n" + Message.BONUS_NUMBER_MESSAGE.getMessage());

            LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto, bonusNumber);
            matchCounts = lottoWinningNumbers.correctNumberCheckerForMultipleLottos(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createWinningNumbers();
        }
    }

    private void createResult() {
        LottoCalculator lottoCalculator = new LottoCalculator(matchCounts);
        List<Integer> ranks = lottoCalculator.calculateRank();
        double returnResult = lottoCalculator.calculateReturnRate(inputCost);

        outputManager.printResult(ranks, returnResult);
    }
}
