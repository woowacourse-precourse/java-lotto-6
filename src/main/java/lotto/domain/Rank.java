package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Rank {
    FIRST(1, "1등", 2_000_000_000, 6, false),
    SECOND(2, "2등", 30_000_000, 5, true),
    THIRD(3, "3등", 1_500_000, 5, false),
    FOURTH(4, "4등", 50_000, 4, false),
    FIFTH(5, "5등", 5_000, 3, false);

    private final int id;
    private final String description;
    private final long prize;
    private final int matchBallCount;
    private final boolean isMatchBonus;

    Rank(int id, String description, long prize, int matchBallCount, boolean isMatchBonus) {
        this.id = id;
        this.description = description;
        this.prize = prize;
        this.matchBallCount = matchBallCount;
        this.isMatchBonus = isMatchBonus;
    }

    public static Rank getRankByMatchBallCount(int matchBallCount, boolean isMatchBonus) {
        for (Rank rank : values()) {
            if (rank.matchBallCount == matchBallCount && rank.isMatchBonus == isMatchBonus) {
                return rank;
            }
        }
        return null;
    }

    public static Map<Rank, RankInfo> getRankInfo(List<Rank> ranks) {
        Map<Rank, RankInfo> rankInfoMap = new HashMap<>();

        for (Rank rank : ranks) {
            if (rank != null) {
                RankInfo rankInfo = rankInfoMap.get(rank);
                if (rankInfo == null) {
                    rankInfo = new RankInfo(rank, 1, rank.getPrize());
                } else {
                    rankInfo.incrementCount();
                }
                rankInfoMap.put(rank, rankInfo);
            }
        }

        return rankInfoMap;
    }

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }

    public String getPrizeByWon() {
        return String.format("%,d", prize);
    }

    public int getMatchBallCount() {
        return matchBallCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}

