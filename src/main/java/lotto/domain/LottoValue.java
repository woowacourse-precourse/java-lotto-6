package lotto.domain;

public enum LottoValue {
    THREE(3, "5,000원"),
    FOUR(4, "50,000원"),
    FIVE(5, "1,500,000원"),
    FIVE_BONUS(5, "30,000,000원"),
    SIX(6, "2,000,000,000원");

    private final int count;
    private final String winningMoney;

    LottoValue(int count, String winningMoney) {
        this.count = count;
        this.winningMoney = winningMoney;
    }

    public int getCount() {
        return this.count;
    }

    public String getWinningMoney() {
        return this.winningMoney;
    }

    public static LottoValue getLottoValue(int count) {
        for (LottoValue lottoValue : LottoValue.values()) {
            if (lottoValue.count == count) {
                return lottoValue;
            }
        }
        return null;
    }

}
