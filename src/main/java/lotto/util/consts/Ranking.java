package lotto.util.consts;

public enum Ranking {
    FIRST(2000000000, 6, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개") {
        @Override
        public boolean isThisRanking(int matchedNumberCount, boolean isBonusNumberMatched) {
            return matchedNumberCount == getMatchedCount() && isBonusNumberMatched;
        }
    },
    THIRD(1500000, 5, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(50000, 4, "4개 일치 (50,000원) - %d개"),
    FIFTH(5000, 3, "3개 일치 (5,000원) - %d개");

    private final int prizeMoney;
    private final int matchedCount;
    private final String message;

    Ranking(int prizeMoney, int matchedCount, String message) {
        this.prizeMoney = prizeMoney;
        this.matchedCount = matchedCount;
        this.message = message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    protected int getMatchedCount() {
        return matchedCount;
    }

    public String getMessage(int count) {
        return String.format(message, count);
    }

    public boolean isThisRanking(int matchedNumberCount, boolean isBonusNumberMatched) {
        return matchedNumberCount == getMatchedCount() && !isBonusNumberMatched;
    }
}
