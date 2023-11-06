package lotto;

import static lotto.Exception.ONLY_DIVISIBLE_BY_THOUSAND;

public class LottoAmount {
    private final int LOTTO_PRICE = 1_000;
    private final int amount;

    public LottoAmount(int money) {
        validateDivisibleByThousand(money);
        this.amount = money;
    }
    public int getAmount() {
        return amount;
    }

    private void validateDivisibleByThousand(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
