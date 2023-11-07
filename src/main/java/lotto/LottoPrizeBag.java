package lotto;

import java.text.MessageFormat;
import java.util.List;

public class LottoPrizeBag {
    private final List<LottoPrize> lottoPrizes;

    public LottoPrizeBag(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public String sayAbout(LottoPrize prizeLevel) {
        if (prizeLevel.equals(LottoPrize.NONE)) {
            throw new IllegalArgumentException("[ERROR] NONE");
        }
        long count = lottoPrizes.stream().filter(prizeLevel::equals).count();

        return MessageFormat.format("{0} - {1}개", prizeLevel.say(), count);
    }

    public double getRateOfReturn() {
        double prizeSum = lottoPrizes.stream().mapToInt(LottoPrize::getCashPrize).sum();
        int priceSum = lottoPrizes.size() * LottoConfig.PRICE;
        return prizeSum / priceSum;
    }

}
