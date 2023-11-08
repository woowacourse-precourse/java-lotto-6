package lotto.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Rank {
    LOSE(0, 0, "낙첨"), FIFTH(3, 5_000, "3개 일치 (5,000원) - "), FOURTH(4, 50_000, "4개 일치 (50,000원) - "), THIRD(5, 1_500_000,
            "5개 일치 (1,500,000원) - "), SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), FIRST(6, 2_000_000_000,
            "6개 일치 (2,000,000,000원) - ");

    final int matchCount;
    final int prize;
    final String resultMessage;
    private static final LinkedHashMap<Rank, Integer> rankCount = new LinkedHashMap<>();

    Rank(int matchCount, int prize, String resultMessage) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.resultMessage = resultMessage;
    }

    public static int getPrize(Rank rank) {
        return rank.prize;
    }

    public static Rank calculate(int matchCount, boolean bonus) {
        if (matchCount < 3) {
            return LOSE;
        }

        if (matchCount == 5 && bonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void initRankCount() {
        for (Rank rank : values()) {
            rankCount.put(rank, 0);
        }
    }

    public static void addRankCount(Rank rank) {
        rankCount.replace(rank, rankCount.get(rank) + 1);
    }

    public static void calculateRankCount() {
        System.out.println(SystemConstants.WINNING_RESULT_MESSAGE);
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            if (entry.getKey() == Rank.LOSE) {
                continue;
            }

            System.out.println(entry.getKey().resultMessage + entry.getValue() + SystemConstants.COUNT_MESSAGE);
        }
    }
}
