package lotto.domain;

import static lotto.exception.Exception.ONLY_DIVISIBLE_BY_THOUSAND;

import java.util.Objects;

public class LottoAmount {
    private final int LOTTO_PRICE = 1_000;
    private final int amount;

    public LottoAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (!Objects.equals(amount % LOTTO_PRICE, 0)) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
