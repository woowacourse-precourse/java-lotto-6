package lotto.domain.lottoresult;

public class LottoPrizeMoney {
    private final long lottoPrizeMoney;

    private LottoPrizeMoney(long lottoPrizeMoney) {
        this.lottoPrizeMoney = lottoPrizeMoney;
    }

    public static LottoPrizeMoney makeZeroLottoPrizeMoney() {
        return new LottoPrizeMoney(0);
    }

    public LottoPrizeMoney updateLottoPrizeMoney(LottoResult lottoResult) {
        return new LottoPrizeMoney(lottoPrizeMoney + lottoResult.getPrizeMoney());
    }

    public long getLottoPrizeMoney() {
        return lottoPrizeMoney;
    }
}
