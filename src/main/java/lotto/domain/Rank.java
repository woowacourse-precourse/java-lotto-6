package lotto.domain;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n"),
    ;

    Rank(int matchCount, int prizeMoney, String winningMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.winningMessage = winningMessage;
    }

    private final int matchCount;
    private final int prizeMoney;
    private final String winningMessage;


    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public static Rank judgeBy(int matchCount, boolean isBonusNumberMatched) {
        if (matchCount == FIRST.matchCount) {
            return Rank.FIRST;
        } else if (matchCount == SECOND.matchCount && isBonusNumberMatched) {
            return Rank.SECOND;
        } else if (matchCount == THIRD.matchCount) {
            return Rank.THIRD;
        } else if (matchCount == FOURTH.matchCount) {
            return Rank.FOURTH;
        }
        return Rank.FIFTH;
    }
}
