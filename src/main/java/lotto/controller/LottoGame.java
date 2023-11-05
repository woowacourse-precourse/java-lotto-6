package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;

public class LottoGame {
    private static final Error INVALID_AMOUNT = Error.INVALID_AMOUNT;
    private static final Error INVALID_FIRST_RANK_NUMBERS = Error.INVALID_FIRST_RANK_NUMBERS;
    private static final Error INVALID_BONUS_NUMBER = Error.INVALID_BONUS_NUMBER;

    private LottoService lottoService;
    private List<Lotto> userLotteries;

    public void init() {
        lottoService = new LottoService();
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
                lottoService.setAmount(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_AMOUNT.getMessage());
            }
        }
    }

    private void getUserLotteries() {
        userLotteries = lottoService.getUserLotto();
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
                lottoService.setFirstRankNumbers(userInput);
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
                lottoService.setBonusNumber(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_BONUS_NUMBER.getMessage());
            }
        }
    }

    private void checkAllLottoScore() {
        for (Lotto lotto : userLotteries) {
            lottoService.checkScore(lotto);
        }
    }

    private void printResults() {
        OutputViewer.printPrefaceOfResult();
        printLottoScoresByRanks();
        OutputViewer.printLastMessageWith(lottoService.getProfitRatio());
    }

    private void printLottoScoresByRanks() {
        for (Rank rank : Rank.values()) {
            printScoreBy(rank);
        }
    }

    private void printScoreBy(Rank rank) {
        int count = lottoService.getCountOf(rank);
        OutputViewer.printLottoResultBy(rank, count);
    }
}
