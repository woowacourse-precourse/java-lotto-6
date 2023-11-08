package lotto.Global;

public enum LottoAmount {
    FIFTH_RESULT(5000),
    FOURTH_RESULT(50000),
    THIRD_RESULT(1500000),
    SECOND_RESULT(30000000),
    FIRST_RESULT(2000000000);

    private int amount;

    private LottoAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return LottoAmount.valueOf(name()).amount;
    }
}
