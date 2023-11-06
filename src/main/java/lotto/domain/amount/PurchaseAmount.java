package lotto.domain.amount;

import static lotto.util.ConstantUtils.*;

public class PurchaseAmount extends Amount {

    protected PurchaseAmount(int amount) {
        super(amount);
        validate(amount);
    }

    public static PurchaseAmount from(int amount) {
        return new PurchaseAmount(amount);
    }

    public PurchaseAmount subtractLottoCost() {
        return new PurchaseAmount(this.amount - LOTTO_COST_CRITERION);
    }

    @Override
    protected void validate(int amount) {
        super.validate(amount);
        validateIsLessThanThousand(amount);
        validateIsDividedByThousand(amount);
    }

    private void validateIsDividedByThousand(int amount) {
        if (amount % LOTTO_COST_CRITERION != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsLessThanThousand(int amount) {
        if (amount < LOTTO_COST_CRITERION) {
            throw new IllegalArgumentException("금액이 1000원 보다 작습니다.");
        }
    }
}
