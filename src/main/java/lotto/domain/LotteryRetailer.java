package lotto.domain;

public class LotteryRetailer {

    private final LottoRandom random;

    public LotteryRetailer(LottoRandom random) {
        this.random = random;
    }

    public LotteryReceipt purchase(LotteryOperator operator, long amount) {
        long quantity = amount / operator.getLotteryPrice();
        return LotteryReceipt.createLotteryReceipt(operator, quantity, random);
    }
}

