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
        return new LotteryReceipt(createPurchasedLotteries(quantity));
    }

    private List<PurchasedLottery> createPurchasedLotteries(long quantity) {
        return LongStream.range(0, quantity)
                .mapToObj(i -> new PurchasedLottery(LottoOperator.currentRound, createLotto()))
                .collect(toList());
    }

    private Lotto createLotto() {
        return new Lotto(random.generateNumbers());
    }
}

