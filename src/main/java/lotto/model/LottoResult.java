package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final static String NEW_LINE = "\n";
    private final static int RANK_COUNTS_INITIALIZE = 0;
    private final static long PROFITS_INITIALIZE = 0;

    private final Map<Rank, Integer> rankCounts;

    public LottoResult() {
        rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, RANK_COUNTS_INITIALIZE);
        }
    }

    public void addOne(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public String buildResultString() {
        StringBuilder builder = new StringBuilder();

        for (Rank rank : Rank.getReverseOrderValues()) {
            builder.append(RankMessage.getMessage(rank, rankCounts.get(rank)));
            builder.append(NEW_LINE);
        }

        return builder.toString();
    }

    public long getProfits() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> RankReward.getRewardOf(rank) * (long) rankCounts.get(rank))
                .reduce(PROFITS_INITIALIZE, Long::sum);
    }
}
