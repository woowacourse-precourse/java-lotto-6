package lotto;

public enum LottoStatics {
    THREE("3개 일치 (5,000원)", 5000, 3),
    FOUR("4개 일치 (50,000원)", 50000, 4),
    FIVE("5개 일치 (1,500,000원)", 1500000, 5),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 5),
    ALL("6개 일치 (2,000,000,000원)", 2000000000, 6);

    private String comment;
    private int reward;
    private int matchCount;

    LottoStatics(String comment, int reward, int matchCount) {
        this.comment = comment;
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public String getComment() {
        return comment;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoStatics getWinningLottoTypeByMatch(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            return matchSpecialFiveAndBonus(matchBonus);
        }
        for (LottoStatics winningLottoType : LottoStatics.values()) {
            if (winningLottoType.getMatchCount() == matchCount) {
                return winningLottoType;
            }
        }
        return null;
    }

    private static LottoStatics matchSpecialFiveAndBonus(boolean matchBonus) {
        if (matchBonus) {
            return LottoStatics.FIVE_BONUS;
        }
        return LottoStatics.FIVE;
    }
}
