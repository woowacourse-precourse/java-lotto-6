package lotto.model;

public enum Rank {

    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5000, "3개 일치 (5,000원) - "), // 5등
    LOOSE(0, 0, "");

    private final int matchNumberCount;
    private final int prizeMoney;
    private final String resultMessage;

    Rank(int matchNumberCount, int prizeMoney, String resultMessage) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
        this.resultMessage = resultMessage;
    }

    public static int getMatchNumberCount(Rank rank) {
        return rank.matchNumberCount;
    }

    public static int getPrizeMoney(Rank rank) {
        return rank.prizeMoney;
    }

    public static String getResultMessage(Rank rank) {
        return rank.resultMessage;
    }


}
