package lotto.view;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankResult {
    public final Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);

    public RankResult() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankResult.put(rank, 0));
    }

    public void calculateResult(List<Integer> matching, List<Boolean> containBonus) {
        for (int i = 0; i < matching.size(); i++) {
            Rank rank = Rank.calculate(matching.get(i), containBonus.get(i));
            updateCount(rank);
        }
    }

    private void updateCount(Rank rank) {
        rankResult.put(rank, rankResult.get(rank) + 1);
    }

    public Integer getCount(Rank rank) {
        return rankResult.get(rank);
    }

}
