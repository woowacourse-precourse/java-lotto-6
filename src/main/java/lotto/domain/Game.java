package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    public Map<Rank, Integer> run(final List<Lotto> lottos, final WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>(
                Map.of(Rank.FIRST, 0, Rank.SECOND, 0, Rank.THIRD, 0,
                        Rank.FOURTH, 0, Rank.FIFTH, 0, Rank.MISS, 0));

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.confirmWin(lotto);
            result.compute(rank, (key, value) -> value + 1);
        }
        return result;
    }
}

