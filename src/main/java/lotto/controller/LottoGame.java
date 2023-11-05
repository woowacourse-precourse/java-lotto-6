package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.Number;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreChecker;
import lotto.domain.LottoSeller;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;
import lotto.utils.StringChanger;

public class LottoGame {
    private static final int LOTTO_PRICE = Number.LOTTO_PRICE.getNumber();
    private static final int NOTHING = 0;
    private static final int TO_RATIO = 100;
    private static final int COUNT_ONE = 1;
    private static final String INVALID_AMOUNT = Error.INVALID_AMOUNT.getMessage();
    private static final String INVALID_FIRST_NUMBERS = Error.INVALID_FIRST_NUMBERS.getMessage();
    private static final String INVALID_BONUS_NUMBER = Error.INVALID_BONUS_NUMBER.getMessage();
    private LottoSeller lottoSeller;
    private LottoScoreChecker lottoScoreChecker;
    private List<Lotto> userLottos;
    private HashMap<Integer, Integer> rankCounts;
    private int userAmount;
    private int countOfLottos;
    private long winnigs;
    private double profitRatio;

    public void init() {
        lottoSeller = new LottoSeller();
        userLottos = new ArrayList<>();
        lottoScoreChecker = new LottoScoreChecker();
        rankCounts = new HashMap<>();
        userAmount = NOTHING;
        countOfLottos = NOTHING;
        winnigs = NOTHING;
        profitRatio = NOTHING;
    }

    public void run() {
        purchaseLotto();
        getWinningNumbers();
        checkLottoRewards();
    }

    private void purchaseLotto() {
        inputAmount();
        giveUserLottos();
        requestPrintPurchasedLottos();
    }

    private void getWinningNumbers() {
        getFirstNumbers();
        getBonusNumber();
    }

    private void checkLottoRewards() {
        checkLottoScore();
        calculateProfit();
        printLottoScore();
    }

    private void inputAmount() {
        while (true) {
            try {
                String userInput = InputViewer.requestAmountInput();
                userInput = StringChanger.trimString(userInput);
                userAmount = lottoSeller.getAmount(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_AMOUNT);
            }
        }
    }

    private void giveUserLottos() {
        countOfLottos = userAmount / LOTTO_PRICE;
        userLottos = lottoSeller.giveLotto();
    }

    private void requestPrintPurchasedLottos() {
        OutputViewer.printCountOfPurchaseLottos(countOfLottos);
        for (Lotto lotto : userLottos) {
            OutputViewer.printPurchasedLotto(lotto);
        }
    }

    private void getFirstNumbers() {
        while (true) {
            try {
                String userInput = InputViewer.requestWinningNumberInput();
                List<String> inputNumbers = StringChanger.stringToTrimmedStringList(userInput);
                lottoScoreChecker.setFirstRankNumbers(inputNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_FIRST_NUMBERS);
            }
        }
    }

    private void getBonusNumber() {
        while (true) {
            try {
                String userInput = InputViewer.requestBonusNumberInput();
                userInput = StringChanger.trimString(userInput);
                lottoScoreChecker.setBonusNumber(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_BONUS_NUMBER);
            }
        }
    }

    private void checkLottoScore() {
        for (Lotto lotto : userLottos) {
            Rank rank = lottoScoreChecker.getRank(lotto);
            countRanks(rank.getRank());
            sumWinnings(rank.getAmount());
        }
    }

    private void countRanks(int rank) {
        if (!rankCounts.containsKey(rank)) {
            rankCounts.put(rank, COUNT_ONE);
            return;
        }
        rankCounts.put(rank, rankCounts.get(rank) + COUNT_ONE);
    }

    private void sumWinnings(long amount) {
        winnigs += amount;
    }

    private void calculateProfit() {
        profitRatio = (double) winnigs / userAmount * TO_RATIO;
    }

    private void printLottoScore() {
        OutputViewer.printPrefaceOfResult();
        for (Rank rank : Rank.values()) {
            printScoreBy(rank);
        }
        OutputViewer.printProfitRatio(profitRatio);
    }

    private void printScoreBy(Rank rank) {
        int rankNumber = rank.getRank();
        if (rankCounts.containsKey(rankNumber)) {
            OutputViewer.printLottoResult(rank, rankCounts.get(rankNumber));
            return;
        }
        OutputViewer.printLottoResult(rank, NOTHING);
    }
}
