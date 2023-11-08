package lotto;

import java.text.MessageFormat;
import java.util.List;
import msg.ErrorMessage;

public class LottoPrizeBag {
    private final List<LottoPrize> lottoPrizes;

    public LottoPrizeBag(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public String sayAbout(LottoPrize prizeLevel) {
        if (prizeLevel.equals(LottoPrize.NONE)) {
            throw new IllegalArgumentException(ErrorMessage.NONE_PRIZE.value());
        }
        long count = lottoPrizes.stream().filter(prizeLevel::equals).count();

        return MessageFormat.format("{0} - {1}개", prizeLevel.say(), count);
    }

    public double getRateOfReturn() {
        double prizeSum = lottoPrizes.stream().mapToInt(LottoPrize::getCashPrize).sum();
        int priceSum = lottoPrizes.size() * LottoConfig.PRICE;
        return (prizeSum / priceSum) * 100;
    }

}
