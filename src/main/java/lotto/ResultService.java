package lotto;

import static lotto.Constants.FIVE_AND_BONUS_CASE_NUMBER;
import static lotto.Constants.FIVE_CASE_NUMBER;
import static lotto.Constants.FOUR_CASE_NUMBER;
import static lotto.Constants.SIX_CASE_NUMBER;
import static lotto.Constants.THREE_CASE_NUMBER;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultService {

    public static int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / InputService.AMOUNT_UNIT;
    }

    public static BigDecimal calculateRateOfReturn(int purchaseAmount, HashMap<Integer, Integer> results) {
        double sum = getSum(results);
        BigDecimal rateOfReturn = new BigDecimal((sum / (double) purchaseAmount) * 100.0);
        rateOfReturn.setScale(1, RoundingMode.HALF_UP);
        return rateOfReturn;
    }

    private static double getSum(HashMap<Integer, Integer> results) {
        double sum = 0.0;
        for (int caseNumber : results.keySet()) {
            sum += WinnigCase.getByCaseNumber(caseNumber).getReward() * results.get(caseNumber);
        }
        return sum;
    }

    public static List<Lotto> getResultsOfLottoIssuance(int numberOfLottoTickets) {
        List<Lotto> resultsOfLottoIssuance = new ArrayList<>();
        for (int i = 1; i <= numberOfLottoTickets; i++) {
            resultsOfLottoIssuance.add(Lotto.createRandomNumbersForLotto());
        }
        return resultsOfLottoIssuance;
    }

    public static HashMap<Integer, Integer> saveWinningResults(
            List<Lotto> resultsOfLottoIssuance, Lotto lotto, int bonusNumber) {
        HashMap<Integer, Integer> winningResults = new HashMap<>();
        winningResults = makeInitialSettings(winningResults);
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
        if (isWinningCase(duplicationNumbers)) {
            winningResults.put(duplicationNumbers, winningResults.get(duplicationNumbers) + 1);
            return winningResults;
        }
        return winningResults;
    }

    private static boolean isWinningCase(int duplicationNumbers) {
        return duplicationNumbers >= THREE_CASE_NUMBER;
    }

    private static boolean isBonusCase(int duplicationNumbers, boolean bonusCheck) {
        return bonusCheck && duplicationNumbers == FIVE_CASE_NUMBER;
    }

    public static HashMap<Integer, Integer> makeInitialSettings(HashMap<Integer, Integer> winningResults) {
        for (int i = 1; i <= Constants.WINNING_CASE_NUMBER; i++) {
            winningResults.put(THREE_CASE_NUMBER, 0);
            winningResults.put(FOUR_CASE_NUMBER, 0);
            winningResults.put(FIVE_CASE_NUMBER, 0);
            winningResults.put(FIVE_AND_BONUS_CASE_NUMBER, 0);
            winningResults.put(SIX_CASE_NUMBER, 0);
        }
        return winningResults;
    }
}
