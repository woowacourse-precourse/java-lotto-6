package lotto.domain;

public enum LottoEnum {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(-1, false, 0);

    private final int count;
    private final boolean isBonus;
    private final int winningMoney;

    LottoEnum(int count, boolean isBonus, int winningMoney) {
        this.count = count;
        this.isBonus = isBonus;
        this.winningMoney = winningMoney;
    }

    public static LottoEnum valueOf(int count, boolean isBonus) {
        for (LottoEnum lottoEnum : LottoEnum.values()) {
            if (lottoEnum.count > count)
                continue;
            if (lottoEnum.isBonus && !isBonus)
                continue;
            return lottoEnum;
        }
        return NOTHING;
    }

    public int getCount() {
        return count;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
