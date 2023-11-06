package lotto.domain;

public class LotteryRetailer {

    private final LottoRandom random;

    public LotteryRetailer(LottoRandom random) {
        this.random = random;
    }

    public LotteryReceipt purchase(LotteryOperator operator, long amount) {
        long quantity = amount / LotteryOperator.LOTTO_PRICE;
        return LotteryReceipt.createLotteryReceipt(operator, quantity, random);
    }
}

