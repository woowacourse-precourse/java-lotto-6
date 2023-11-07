package lotto.domain;

public enum Rank {
    NONE(0,false, 0, "3개 미만 일치"),
    FIFTH(3, false, 5000, "3개 일치"),
    FOURTH(4, false, 50000, "4개 일치"),
    THIRD(5, false, 1500000, "5개 일치"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2000000000, "6개 일치");

    private final int count;
    private final boolean bonusBall;
    private final int awardMoney;
    private final String message;

    Rank(int count, boolean bonusBall, int awardMoney, String message) {
        this.count = count;
        this.bonusBall = bonusBall;
        this.awardMoney = awardMoney;
        this.message = message;
    }
    public int getCount() {
        return count;
    }
    public boolean getBonusBall() {
        return bonusBall;
    }
    public int getAwardMoney() {
        return awardMoney;
    }
    public String getMessage() {
        return message;
    }

    public static Rank valueOf(int count, boolean bonusBall) {
        if (count == 5 && bonusBall) {
            return SECOND;
        }
        if (count == 5 && !bonusBall) {
            return THIRD;
        }
        for (Rank rank : Rank.values()) {
            if (rank.count == count) {
                return rank;
            }
        }
        return NONE;
    }
}
