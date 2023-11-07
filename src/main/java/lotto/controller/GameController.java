package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    public static void start() {
        int userMoney = getUserMoney();
        int lottoAmount = calculateLottoAmount(userMoney);
        printLottoCount(lottoAmount);
        List<Lotto> lottoList = generateLottoList(lottoAmount);
        printLottoList(lottoList);
        List<Integer> winNumbers = getWinNumbers();
        int bonusNumber = getBonusNumber();
        Judge judge = new Judge();
        List<LottoResult> results = judge.countMatchingNumbers(lottoList, winNumbers);
        printWinningResults(judge, results, bonusNumber, lottoList);
        printProfitRate(userMoney, results);
    }

    private static int getUserMoney() {
        return InputView.inputMoney();
    }

    private static int calculateLottoAmount(int userMoney) {
        Counter counter = new Counter();
        return counter.generateLottoCount(userMoney);
    }

    private static void printLottoCount(int lottoAmount) {
        OutputView outputView = new OutputView();
        outputView.printLottoCount(lottoAmount);
    }

    private static List<Lotto> generateLottoList(int lottoAmount) {
        LottoGenerate lottoGenerate = new LottoGenerate();
        return lottoGenerate.generateLottoNumbers(lottoAmount);
    }

    private static void printLottoList(List<Lotto> lottoList) {
        OutputView outputView = new OutputView();
        outputView.printLottoList(lottoList);
    }

    private static List<Integer> getWinNumbers() {
        InputView inputView = new InputView();
        return inputView.inputWinNumbers();
    }

    private static int getBonusNumber() {
        InputView inputView = new InputView();
        return inputView.inputBonusNumber();
    }

    private static void printWinningResults(Judge judge, List<LottoResult> results, int bonusNumber, List<Lotto> lottoList) {
        Map<WinningResult, Integer> resultMap = new HashMap<>();
        for (LottoResult result : results) {
            int count = result.getMatchingCount();
            boolean bonusMatch = judge.isBonusMatch(lottoList, bonusNumber);
            WinningResult winningResult = judge.determineWinningResult(count, bonusMatch);
            resultMap.put(winningResult, resultMap.getOrDefault(winningResult, 0) + 1);
        }
        OutputView.printWinningResult(resultMap);
    }

    private static void printProfitRate(int userMoney, List<LottoResult> results) {
        Counter counter = new Counter();
        long totalPrize = calculateTotalPrize(results);
        double profitRate = counter.calculateProfitRate(userMoney, totalPrize);
        OutputView outputView = new OutputView();
        outputView.printCalculateProfit(profitRate);
    }

    private static long calculateTotalPrize(List<LottoResult> results) {
        long totalPrize = 0;
        for (LottoResult result : results) {
            WinningResult winningResult = result.getWinningResult();
            if (winningResult != null) {
                totalPrize += winningResult.getPrize();
            }
        }
        return totalPrize;
    }

}
