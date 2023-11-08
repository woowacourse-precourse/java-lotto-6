package lotto.model;


public class Cash {

    private final int UNIT = 1000;
    private static int amount = 0;
    public Cash(int amount) {
        validateAmount(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    public int getCount() {
        return this.amount / UNIT;
    }

    public static int getAmount() { return amount; }

    private void validateAmount(int amount) {
        if(amount < 1000) {
            throw new IllegalArgumentException("최소 금액은 1000원 입니다.");
        }
    }

    private void validateAmountUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("1000원 단위로만 참여 가능합니다.");
        }
    }
}