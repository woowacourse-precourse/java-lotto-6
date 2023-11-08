package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.service.ResultService;
import lotto.userInterface.ErrorMessageViewer;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;

public class LottoGame {
    private ResultService resultService;
    private List<Lotto> userLotteries;

    public void init() {
        resultService = new ResultService();
        userLotteries = new ArrayList<>();
    }

    public void run() {
        purchaseLotto();
        getWinningNumbers();
        checkLottoRewards();
    }

    private void purchaseLotto() {
        inputAmount();
        getUserLotteries();
        printPurchasedLotteries();
    }

    private void getWinningNumbers() {
        getFirstRankNumbers();
        getBonusNumber();
    }

    private void checkLottoRewards() {
        determineAllLottoScore();
        printResults();
    }

    private void inputAmount() {
        while (true) {
            try {
                String userInput = InputViewer.requestAmountInput();
                resultService.setAmount(userInput);
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessageViewer.printInvalidAmount();
            }
        }
    }

    private void getUserLotteries() {
        userLotteries = resultService.getUserLotto();
    }

    private void printPurchasedLotteries() {
        OutputViewer.printNumberOf(userLotteries.size());
        for (Lotto lotto : userLotteries) {
            OutputViewer.printPurchased(lotto.getNumbers());
        }
    }

    private void getFirstRankNumbers() {
        while (true) {
            try {
                String userInput = InputViewer.requestFirstRankNumberInput();
                resultService.setFirstRankNumbers(userInput);
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessageViewer.printInvalidFirstRankNumbers();
            }
        }
    }

    private void getBonusNumber() {
        while (true) {
            try {
                String userInput = InputViewer.requestBonusNumberInput();
                resultService.setBonusNumber(userInput);
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessageViewer.printInvalidBonusNumber();
            }
        }
    }

    private void determineAllLottoScore() {
        for (Lotto lotto : userLotteries) {
            resultService.determineScore(lotto);
        }
    }

    private void printResults() {
        OutputViewer.printPrefaceOfResult();
        printLottoScoresByRank();
        OutputViewer.printLastMessageWith(resultService.getProfitRatio());
    }

    private void printLottoScoresByRank() {
        for (Rank rank : Rank.values()) {
            printScoreBy(rank);
        }
    }

    private void printScoreBy(Rank rank) {
        int count = resultService.getCountOf(rank);
        OutputViewer.printLottoResultBy(rank, count);
    }
}
