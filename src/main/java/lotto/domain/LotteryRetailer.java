package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.LongStream;

public class LotteryRetailer {

    private final LottoRandom random;

    public LotteryRetailer(LottoRandom random) {
        this.random = random;
    }

    public LotteryReceipt purchase(long amount) {
        long quantity = amount / LottoOperator.LOTTO_PRICE;
        return LotteryReceipt.createLotteryReceipt(quantity, random);
    }
}

