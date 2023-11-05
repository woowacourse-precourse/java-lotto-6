package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankCounts;

    public LottoResult() {
        rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addOne(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public String buildResultString() {
        StringBuilder builder = new StringBuilder();

        for (Rank rank : Rank.getReverseOrderValues()) {
            builder.append(RankMessage.getMessage(rank, rankCounts.get(rank)));
            builder.append("\n");
        }

        return builder.toString();
    }
}
