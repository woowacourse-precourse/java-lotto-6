package lotto.domain;

public enum Rank {
    FIFTH(5_000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(50_000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n"),
    ;

    Rank(int prizeMoney, String winningMessage) {
        this.prizeMoney = prizeMoney;
        this.winningMessage = winningMessage;
    }

    private final int prizeMoney;
    private final String winningMessage;

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public static Rank calcualteBy(int matchCount, boolean isBonusNumberMatched) {
        if(matchCount == 6) {
            return Rank.FIRST;
        } else if(matchCount == 5 && isBonusNumberMatched) {
            return Rank.SECOND;
        } else if(matchCount == 5) {
            return Rank.THIRD;
        } else if(matchCount == 4) {
            return Rank.FOURTH;
        }
        return Rank.FIFTH;
    }
}
