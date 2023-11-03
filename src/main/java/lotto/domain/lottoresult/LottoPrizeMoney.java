package lotto.domain.lottoresult;

public class LottoPrizeMoney {
    private final long lottoPrizeMoney;

    public LottoPrizeMoney(long lottoPrizeMoney) {
        this.lottoPrizeMoney = lottoPrizeMoney;
    }

    public LottoPrizeMoney updateLottoPrizeMoney(LottoResult lottoResult) {
        return new LottoPrizeMoney(lottoPrizeMoney + lottoResult.getPrizeMoney());
    }

    public long getLottoPrizeMoney() {
        return lottoPrizeMoney;
    }
}
