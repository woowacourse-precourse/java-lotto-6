package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<Lotto> lottos;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public GameResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getNumbersInAscendingOrder();
        List<Integer> winningNumbers = winningLotto.getNumbersInAscendingOrder();
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Rank> getResults() {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningLotto);
            boolean hasBonusNumber = lotto.getNumbersInAscendingOrder().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, hasBonusNumber);
            results.add(rank);
        }
        return results;
    }
}