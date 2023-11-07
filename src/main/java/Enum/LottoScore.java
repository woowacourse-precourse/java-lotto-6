package Enum;

public enum LottoScore {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NO(0, false, 0);

    private final int correctNumber;
    private final boolean correctBonus;
    private final int prizeMoney;

    LottoScore(int correctNumber, boolean correctBonus, int prizeMoney) {
        this.correctNumber = correctNumber;
        this.correctBonus = correctBonus;
        this.prizeMoney = prizeMoney;
    }
}
