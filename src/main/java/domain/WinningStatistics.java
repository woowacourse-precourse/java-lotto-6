package domain;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class WinningStatistics {
    private Ranking ranking;
    private float rateOfReturn;
    private int matchingCount;
    private static HashMap<Ranking, Integer> totalRanking = new HashMap<>();

    private static final int ONE_HUNDRED = 100;

    public WinningStatistics(Lotto resultNumbers,
                             List<Lotto> lotties,
                             int bonusNumber,
                             int lottoPurchaseAmount) {
        checkLotto(resultNumbers, lotties, bonusNumber);
        setRateOfReturn(lottoPurchaseAmount);
    }

    public WinningStatistics(Lotto resultNumber, Lotto userNumber) { //Test
        setMatchingCount(resultNumber, userNumber);
    }

    public WinningStatistics() { //Test

    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public float getRateOfReturn() {
        return rateOfReturn;
    }

    public HashMap<Ranking, Integer> getTotalRanking() {
        return totalRanking;
    }

    private void checkLotto(Lotto resultLotto, List<Lotto> lotties, int bonusNumber) {
        setTotalRanking();
        for (int i = 0; i < lotties.size(); i++) {
            setMatchingCount(resultLotto, lotties.get(i));
            ranking = ranking.value(matchingCount, checkBonusNumber(resultLotto, bonusNumber));
            saveTotalRanking(ranking);
        }
    }

    private void setMatchingCount(Lotto resultLotto, Lotto userLotto) {
        List<Integer> resultNumbers = resultLotto.getNumbers();
        List<Integer> userNumbers = userLotto.getNumbers();
        int checkCount = (int) userNumbers.stream().filter(resultNumbers::contains).count();
        this.matchingCount = checkCount;
    }

    public static boolean checkBonusNumber(Lotto resultLotto, int bonusNumber) {
        List<Integer> resultNumbers = resultLotto.getNumbers();
        return resultNumbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    private static void setTotalRanking() {
        totalRanking.put(Ranking.FIRST, 0);
        totalRanking.put(Ranking.SECOND, 0);
        totalRanking.put(Ranking.THIRD, 0);
        totalRanking.put(Ranking.FOURTH, 0);
        totalRanking.put(Ranking.FIFTH, 0);
        totalRanking.put(Ranking.MISS, 0);
    }

    private void saveTotalRanking(Ranking ranking) {
        int currentCount = totalRanking.get(ranking);
        totalRanking.put(ranking, currentCount + 1);
    }

    private void setRateOfReturn(int lottoPurchaseAmount) {
        rateOfReturn = 0;
        for (Ranking ranking : ranking.values()) {
            if (ranking == Ranking.MISS) {
                continue;
            }
            rateOfReturn += ranking.getWinningAmount() * totalRanking.get(ranking);
        }
        rateOfReturn = rateOfReturn / lottoPurchaseAmount * ONE_HUNDRED;
    }

}
