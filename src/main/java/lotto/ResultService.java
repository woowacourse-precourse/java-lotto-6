package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultService {

    public static final int WINNING_CASE_NUMBER = 5;
    public static final int THREE_CASE_NUMBER = 3;
    public static final int FOUR_CASE_NUMBER = 4;
    public static final int FIVE_CASE_NUMBER = 5;
    public static final int FIVE_AND_BONUS_CASE_NUMBER = 7;
    public static final int SIX_CASE_NUMBER = 6;

    public static int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / InputService.AMOUNT_UNIT;
    }

    public static void printNumberOfLottoTickets(int purchaseNumber) {
        System.out.printf("%d개를 구매했습니다.", purchaseNumber);
    }

    public static void printStringForResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResults(HashMap<Integer, Integer> results) {
        for (int caseNumber : results.keySet()) {
            System.out.printf(WinnigCase.getByCaseNumber(caseNumber).getContents()
                    + " - %d개", results.get(caseNumber));
        }
    }

    public static double calculateRateOfReturn() {
        return 1.0;
    }


    public static List<Lotto> getResultsOfLottoIssuance(int purchaseNumber) {
        List<Lotto> resultsOfLottoIssuance = new ArrayList<>();
        for (int i = 1; i <= purchaseNumber; i++) {
            resultsOfLottoIssuance.add(Lotto.createRandomNumbersForLotto());
        }
        return resultsOfLottoIssuance;
    }

    public static void printResultsOfLottoIssuance(List<Lotto> resultsOfLottoIssuance) {
        for (Lotto result : resultsOfLottoIssuance) {
            printSortResult(result);
        }
    }

    private static void printSortResult(Lotto result) {
        List<Integer> sortedResult = result.sortNumbers(result);
        System.out.println(sortedResult);
    }

    public static HashMap<Integer, Integer> saveWinningResults(
            List<Lotto> resultsOfLottoIssuance, Lotto lotto, int bonusNumber) {
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        makeInitialSettings(winningResults);
        for (Lotto resultOfLottoIssuance : resultsOfLottoIssuance) {
            saveWinningResult(lotto, bonusNumber, resultOfLottoIssuance, winningResults);
        }
        return winningResults;
    }

    public static HashMap<Integer, Integer> saveWinningResult(
            Lotto lotto, int bonusNumber, Lotto resultOfLottoIssuance, HashMap<Integer, Integer> winningResults) {
        int duplicationNumbers = resultOfLottoIssuance.getDuplicationNumbers(lotto, resultOfLottoIssuance);
        boolean bonusCheck = resultOfLottoIssuance.IsBonusNumberIncluded(resultOfLottoIssuance, bonusNumber);
        return saveMatches(duplicationNumbers, winningResults, bonusCheck);
    }

    private static HashMap<Integer, Integer> saveMatches(int duplicationNumbers,
                                                         HashMap<Integer, Integer> winningResults,
                                                         boolean bonusCheck) {
        if (isBonusCase(duplicationNumbers, bonusCheck)) {
            winningResults.put(FIVE_AND_BONUS_CASE_NUMBER, winningResults.get(FIVE_AND_BONUS_CASE_NUMBER) + 1);
            return winningResults;
        }
        winningResults.put(duplicationNumbers, winningResults.get(duplicationNumbers) + 1);
        return winningResults;
    }

    private static boolean isBonusCase(int duplicationNumbers, boolean bonusCheck) {
        return bonusCheck && duplicationNumbers == FIVE_CASE_NUMBER;
    }


    public static void makeInitialSettings(HashMap<Integer, Integer> winningResults) {
        for (int i = 1; i <= WINNING_CASE_NUMBER; i++) {
            winningResults.put(THREE_CASE_NUMBER, 0);
            winningResults.put(FOUR_CASE_NUMBER, 0);
            winningResults.put(FIVE_CASE_NUMBER, 0);
            winningResults.put(FIVE_AND_BONUS_CASE_NUMBER, 0);
            winningResults.put(SIX_CASE_NUMBER, 0);
        }
    }

}
