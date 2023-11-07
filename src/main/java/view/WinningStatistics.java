package view;

import java.util.List;
import lotto.Lotto;

public class WinningStatistics {

    private Ranking ranking;
    private float rateOfReturn;
    private int matchingCount;

    public WinningStatistics(Lotto resultLotto, Lotto userLotto) { // Test 용 생성자
        setMatchingCount(resultLotto, userLotto);
    }

    public WinningStatistics() {
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public WinningStatistics(Lotto resultNumbers, List<Lotto> lotties, int bonusNumber) {
        checkLotto(resultNumbers, lotties, bonusNumber);
    }

    private void checkLotto(Lotto resultLotto, List<Lotto> lotties, int bonusNumber) {
        for (int i = 0; i < lotties.size(); i++) {
            setMatchingCount(resultLotto, lotties.get(i));
            this.ranking = ranking.value(matchingCount, checkBonusNumber(resultLotto, bonusNumber));
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


}
