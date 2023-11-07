package lotto.domain;

public enum ResultLotto {
    ZERO(0),
    ONE(0),
    TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_BONUS(30_000_000),
    SIX(2_000_000_000);

    private int result;

    ResultLotto(int result) {
        this.result = result;
    }

    public static ResultLotto getOrdinal(int ordinal) {
        return ResultLotto.values()[ordinal];
    }

    public long getResult() {
        return result;
    }
}