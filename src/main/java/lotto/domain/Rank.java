package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    NOTHING(0, false, 0, "");

    private final boolean bonus;
    private final int containNum;
    private final int prizeAmount;
    private final String winningMessage;

    Rank(int containNum, boolean bonus, int prizeAmount, String winningMessage) {
        this.containNum = containNum;
        this.bonus = bonus;
        this.prizeAmount = prizeAmount;
        this.winningMessage = winningMessage;
    }

    public static Rank decideRank(int countMatch, boolean bonusMatch) {
        for (Rank value : Rank.values()) {
            if (countMatch == value.containNum && bonusMatch == value.bonus) {
                return value;
            }
        }
        return NOTHING;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static String getWinningMesaage(Rank rank) {
        return rank.winningMessage;
    }
    //TODO : RANK TEST
}

