package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result;

    public Result() {
        this.result = initResult();
    }

    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> initResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            initResult.put(rank, 0);
        }
        return initResult;
    }

    public void calculateWinning(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = determineRank(lotto, winningLotto);
            increaseRankCount(rank);
        }
    }

    private void increaseRankCount(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    private Rank determineRank(Lotto lotto, WinningLotto winningLotto) {
        int correctNumbers = getCorrectNumbers(lotto, winningLotto);
        boolean matchBonus = isBonusCorrect(lotto, winningLotto);
        return Rank.valueOf(correctNumbers, matchBonus);
    }

    private int getCorrectNumbers(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getCorrectNumbers(winningLotto.getCurrentWinningNumbers());
    }

    private boolean isBonusCorrect(Lotto lotto, WinningLotto winningLotto) {
        return lotto.isExist(winningLotto.getBonusNumber());
    }

}
