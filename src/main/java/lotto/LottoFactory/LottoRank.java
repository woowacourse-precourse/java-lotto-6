package lotto.LottoFactory;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    FIRST(6, false, "1등", 2_000_000_000),
    SECOND(5, true, "2등", 30_000_000),
    THIRD(5, false, "3등", 1_500_000),
    FOURTH(4, false, "4등", 50_000),
    FIFTH(3, false, "5등", 5_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final String rankName;
    private final long prizeMoney;
    private final Map<LottoRank, Integer> Ranking;
    private static int AllPrizeMoney = 0;

    LottoRank(int matchCount, boolean bonusMatch, String rankName, long prizeMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.rankName = rankName;
        this.prizeMoney = prizeMoney;
        this.Ranking = new HashMap<>();
    }

    public static void CheckAndStoreRank(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.bonusMatch || bonusMatch)) {
                rank.addToRanking(rank);
                AllPrizeMoney += rank.prizeMoney;
                return;
            }
        }
    }

    public void addToRanking(LottoRank rank) {
        Ranking.put(rank, Ranking.getOrDefault(rank, 0) + 1);
    }

    public  Map<LottoRank, Integer> getRanking() {
        return Ranking;
    }

    public static int getAllPrizeMoney(){
        return AllPrizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }


    public long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusBallMatch() {
        return bonusMatch;
    }
}
