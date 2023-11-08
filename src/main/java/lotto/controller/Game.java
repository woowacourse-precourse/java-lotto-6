package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {

    private InputView inputView;
    private OutputView outputView;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        GameResult.create();
        init();
    }

    public void run() {

        List<Lotto> purchaseLotto = LottoStorage.getLotto();

        for (Lotto lotto : purchaseLotto) {

            float correctCount = LottoWinner.compareWinningLotto(lotto);
            if (correctCount == 5) {
                correctCount += LottoWinner.compareBonusLotto(lotto);
            }

            WinnerPrize winnerPrize = WinnerPrize.findWinnerPrize(correctCount);

            GameResult.increaseWinnerPrizeCount(winnerPrize);

            // 수익률 계산

        }
    }

    private void init() {
        int purchasePrice = requestPurchasePrice();
        LottoGenerator.generateLotto(purchasePrice);
        List<Lotto> purchaseLotto = LottoStorage.getLotto();
        outputView.printPurchaseLotto(purchaseLotto);

        Lotto winningLotto = requestWinningLotto();
        Bonus bonusLotto = requestBonusLotto();
        LottoWinner.create(winningLotto, bonusLotto);

        inputView.closeInputConsole();
    }

    private int requestPurchasePrice() {
        while (true) {
            int purchasePrice;
            try {
                purchasePrice = inputView.requestPurchasePrice();
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
                continue;
            }
            outputView.printBlank();
            return purchasePrice;
        }
    }

    private Lotto requestWinningLotto() {
        while (true) {
            Lotto winningLotto;
            try {
                List<Integer> winningNumbers = inputView.requestWinningNumber();
                winningLotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
                continue;
            }
            outputView.printBlank();
            return winningLotto;
        }
    }

    private Bonus requestBonusLotto() {
        while (true) {
            Bonus bonus;
            try {
                int bonusNumber = inputView.requestBonusNumber();
                bonus = new Bonus(bonusNumber);
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
                continue;
            }
            outputView.printBlank();
            return bonus;
        }
    }
}
