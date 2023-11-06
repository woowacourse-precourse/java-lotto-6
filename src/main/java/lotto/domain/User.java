package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> checkResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = initResult();

        for (Lotto lotto : lottos) {
            Rank rank = WinningLotto.compare(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }
    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
