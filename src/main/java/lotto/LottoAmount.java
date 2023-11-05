package lotto;

import static lotto.Exception.ONLY_DIVISIBLE_BY_THOUSAND;

public class LottoAmount {
    private int amount;

    public LottoAmount(int money) {
        validateDivisibleByThousand(money);
        this.amount = money;
    }

    private void validateDivisibleByThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
