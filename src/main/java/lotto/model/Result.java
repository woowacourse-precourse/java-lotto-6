package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.Lotto;

public class Result {
    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    public Result(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.get()) {
            Rank rank = Rank.of(lotto.countSameNumbers(winningLotto), lotto.isContain(winningLotto.getBonusNumber()));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }
}
