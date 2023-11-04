package lotto.domain.money;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        validateIsAmountZero(amount);
        validateAmountUnit(amount);
    }

    private void validateIsAmountZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("[ERROR] 0원은 입력할 수 없습니다.");
        }
    }

    private void validateAmountUnit(int amount) {
        if(amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
