package lotto.domain.amount;

import static lotto.util.ConstantUtils.*;

public class PurchaseAmount extends Amount {

    protected PurchaseAmount(int amount) {
        super(amount);
        if (amount % LOTTO_COST_CRITERION != 0) {
            throw new IllegalArgumentException("구입 금액이 1000원으로 나누어 떨어지지 않습니다");
        }
    }

    public static PurchaseAmount from(int amount) {
        if (amount < LOTTO_COST_CRITERION) {
            throw new IllegalArgumentException("구입 금액이 1000원 보다 작습니다.");
        }
        return new PurchaseAmount(amount);
    }

    public boolean isEnough() {
        return amount >= LOTTO_COST_CRITERION;
    }

    public PurchaseAmount subtractLottoCost() {
        return new PurchaseAmount(this.amount - LOTTO_COST_CRITERION);
    }
}
