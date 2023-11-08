package lotto.domain;

import java.util.Objects;

public class LotteryRetailer {
    private final LottoRandom random;

    public LotteryRetailer(LottoRandom random) {
        this.random = Objects.requireNonNull(random);
    }

    private static void validate(LotteryOperator operator, long amount) {
        if (amount % operator.getLotteryPrice() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public LotteryReceipt purchase(LotteryOperator operator, long amount) {
        validate(operator, amount);
        long quantity = amount / operator.getLotteryPrice();
        return LotteryReceipt.createLotteryReceipt(operator, quantity, random);
    }
}

