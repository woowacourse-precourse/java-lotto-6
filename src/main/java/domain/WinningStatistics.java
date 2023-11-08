package domain;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class WinningStatistics {

    private Ranking ranking;
    private float rateOfReturn;
    private int matchingCount;
    private static HashMap<Ranking, Integer> totalRanking;

    public WinningStatistics(Lotto resultLotto, Lotto userLotto) { // Test 용 생성자
        setMatchingCount(resultLotto, userLotto);
    }

    public WinningStatistics() {
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public WinningStatistics(Lotto resultNumbers, List<Lotto> lotties, int bonusNumber, int lottoPurchaseAmount) {
        checkLotto(resultNumbers, lotties, bonusNumber);
        setRateOfReturn(lottoPurchaseAmount);
        result();
    }

    private void checkLotto(Lotto resultLotto, List<Lotto> lotties, int bonusNumber) {
        setTotalRanking(ranking);
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

    private static void setTotalRanking(Ranking ranking) {
        totalRanking = new HashMap<>();
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

    private void result() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Ranking ranking : ranking.values()) {
            if (ranking == Ranking.MISS) {
                continue;
            }
            System.out.println(ranking.getWinningMessage() + totalRanking.get(ranking) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);

    }

    private void setRateOfReturn(int lottoPurchaseAmount) {
        rateOfReturn = 0;
        for (Ranking ranking : ranking.values()) {
            if (ranking == Ranking.MISS) {
                continue;
            }
            rateOfReturn += ranking.getWinningAmount() * totalRanking.get(ranking);
        }
        rateOfReturn = rateOfReturn / lottoPurchaseAmount * 100;
    }
}
