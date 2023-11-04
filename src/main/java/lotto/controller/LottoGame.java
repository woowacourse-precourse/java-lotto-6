package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreChecker;
import lotto.domain.LottoSeller;
import lotto.domain.Rank;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;
import lotto.utils.StringChanger;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
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
        userAmount = 0;
        countOfLottos = 0;
        winnigs = 0;
        profitRatio = 0.0;
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
        String userInput = InputViewer.requestAmountInput();
        userInput = StringChanger.trimString(userInput);
        userAmount = lottoSeller.getAmount(userInput);
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
        String userInput = InputViewer.requestWinningNumberInput();
        lottoScoreChecker.setFirstNumbers(userInput);
    }

    private void getBonusNumber() {
        String userInput = InputViewer.requestBonusNumberInput();
        lottoScoreChecker.setBonusNumber(userInput);
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
            rankCounts.put(rank, 1);
            return;
        }
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    private void sumWinnings(long amount) {
        winnigs += amount;
    }

    private void calculateProfit() {
        profitRatio = (double) winnigs / userAmount * 100;
    }

    private void printLottoScore() {
        OutputViewer.printTitleOfResult();
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
        OutputViewer.printLottoResult(rank, 0);
    }
}
