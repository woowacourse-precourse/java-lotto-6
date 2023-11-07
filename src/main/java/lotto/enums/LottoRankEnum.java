package lotto.enums;

public enum LottoRankEnum {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);


    private final int sameCount;
    private final boolean containsBonus;
    private final int prize;

    LottoRankEnum(int sameCount, boolean containsBonus, int prize) {
        this.sameCount = sameCount;
        this.containsBonus = containsBonus;
        this.prize = prize;
    }

}
