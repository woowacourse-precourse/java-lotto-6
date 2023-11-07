package lotto.enums;

public enum LottoRankEnum {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);


    private final int sameCount;
    private final boolean containsBonus;
    private final int prize;

    LottoRankEnum(int sameCount, boolean containsBonus, int prize) {
        this.sameCount = sameCount;
        this.containsBonus = containsBonus;
        this.prize = prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isContainsBonus() {
        return containsBonus;
    }

    public int getPrize() {
        return prize;
    }
}
