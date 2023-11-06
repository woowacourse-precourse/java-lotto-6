package lotto.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Result {
    private Map<Rank, Integer> rankAndCounting;

    public Result() {
        this.rankAndCounting = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            rankAndCounting.put(rank, 0);
        }
    }

    public void compare(Lottos lottos, WinningLotto winningLotto, Bonus bonus) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.calculateRank(lotto, winningLotto, bonus);

            rankAndCounting.put(rank, rankAndCounting.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getRankAndCounting() {
        return rankAndCounting;
    }

    public int calculateTotalSum() {
        int sum = 0;
        for (Rank rank : rankAndCounting.keySet()) {
            if (rankAndCounting.get(rank) != 0) {
                sum += Rank.getPrize(rank) * rankAndCounting.get(rank);
            }
        }
        return sum;
    }
}
