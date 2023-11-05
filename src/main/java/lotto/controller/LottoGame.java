package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.service.ResultService;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;

public class LottoGame {
    private static final Error INVALID_AMOUNT = Error.INVALID_AMOUNT;
    private static final Error INVALID_FIRST_RANK_NUMBERS = Error.INVALID_FIRST_RANK_NUMBERS;
    private static final Error INVALID_BONUS_NUMBER = Error.INVALID_BONUS_NUMBER;

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
        checkAllLottoScore();
        printResults();
    }

    private void inputAmount() {
        while (true) {
            try {
                String userInput = InputViewer.requestAmountInput();
                resultService.setAmount(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_AMOUNT.getMessage());
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
                System.out.println(INVALID_FIRST_RANK_NUMBERS.getMessage());
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
                System.out.println(INVALID_BONUS_NUMBER.getMessage());
            }
        }
    }

    private void checkAllLottoScore() {
        for (Lotto lotto : userLotteries) {
            resultService.checkScore(lotto);
        }
    }

    private void printResults() {
        OutputViewer.printPrefaceOfResult();
        printLottoScoresByRanks();
        OutputViewer.printLastMessageWith(resultService.getProfitRatio());
    }

    private void printLottoScoresByRanks() {
        for (Rank rank : Rank.values()) {
            printScoreBy(rank);
        }
    }

    private void printScoreBy(Rank rank) {
        int count = resultService.getCountOf(rank);
        OutputViewer.printLottoResultBy(rank, count);
    }
}
