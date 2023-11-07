package lotto.domain;

public enum Rank{
    FIRST(6, 0, "6개 일치 (2,000,000,000원) - %d개", 2000000000, false),
    SECOND(5, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000, true),
    THIRD(5, 0, "5개 일치 (1,500,000원) - %d개", 1500000, false),
    FOURTH(4, 0, "4개 일치 (50,000원) - %d개", 50000, false),
    FIFTH(3, 0, "3개 일치 (5,000원) - %d개", 5000, false);

    private final String rankMessage;
    private final int matchCount;
    private int winningAmount;
    private final int money;
    private final boolean hasBonusNumber;

    Rank(int matchCount, int winningAmount, String rankMessage, int money, boolean hasBonusNumber) {
        this.rankMessage = rankMessage;
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static void increaseRankResult(int matchResult, boolean hasBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchResult && rank.hasBonusNumber == hasBonusNumber) {
                ++rank.winningAmount;
            }
        }
    }

    public String getRankMessage(){
        return this.rankMessage;
    }

    public int getWinningAmount(){
        return this.winningAmount;
    }

    public int getMoney() {
        return money;
    }
}
