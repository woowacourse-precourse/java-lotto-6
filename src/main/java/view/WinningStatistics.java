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

    public int getMatchingCount() {
        return matchingCount;
    }

    public WinningStatistics(Lotto resultNumbers, List<Lotto> lotties) {
        checkLotto(resultNumbers, lotties);
//        System.out.println(ranking.getWinningAmount());
    }

    private void checkLotto(Lotto resultLotto, List<Lotto> lotties) {
        for (int i = 0; i < lotties.size(); i++) {
            setMatchingCount(resultLotto, lotties.get(i);
            this.ranking = ranking.value(matchingCount, true);
        }
    }
    private void setMatchingCount(Lotto resultLotto, Lotto userLotto) {
        List<Integer> resultNumbers = resultLotto.getNumbers();
        List<Integer> userNumbers = userLotto.getNumbers();
        int checkCount = (int) userNumbers.stream().filter(resultNumbers::contains).count();
        this.matchingCount = checkCount;
    }


}
