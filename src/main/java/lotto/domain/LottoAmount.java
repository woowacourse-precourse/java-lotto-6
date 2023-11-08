package lotto.domain;

import static lotto.exception.Exception.ONLY_DIVISIBLE_BY_THOUSAND;

import java.util.Objects;

public record LottoAmount (int amount) {
    private static final int LOTTO_PRICE = 1_000;

    public LottoAmount {
        validate(amount);
    }

    private void validate(int amount) {
        if (!Objects.equals(amount % LOTTO_PRICE, 0)) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
