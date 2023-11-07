package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static lotto.domain.LottoPrize.*;

public class LottoResult {

    private final List<LottoPrize> lottoPrizes = new ArrayList<>();

    public List<LottoPrize> getLottoPrizes() {
        return lottoPrizes;
    }

    public void addPrize(LottoPrize lottoPrize) {
        if (!lottoPrize.equals(NONE))
            lottoPrizes.add(lottoPrize);
    }

    public int getPrizeMoney() {
        AtomicInteger resultMoney = new AtomicInteger(0);
        lottoPrizes.forEach(lottoPrize -> resultMoney.addAndGet(lottoPrize.getPrizeMoney()));

        return resultMoney.get();
    }

    public String getPrizeDescription(int prize) {
        LottoPrize lottoPriceByPrize = LottoPrize.getLottoPrizeByPrize(prize);
        long count = getCountOfPrizes(lottoPriceByPrize);

        return buildPrizeDescription(lottoPriceByPrize, count);
    }

    private long getCountOfPrizes(LottoPrize lottoPriceByPrize) {
        return lottoPrizes.stream()
                .filter(lottoPriceByPrize::equals)
                .count();
    }

    private String buildPrizeDescription(LottoPrize lottoPrizeByPrize, long count) {
        StringBuilder prefix = new StringBuilder(lottoPrizeByPrize.getMatchesNumber() + "개 일치");
        if (lottoPrizeByPrize == SECOND)
            prefix.append(", 보너스 볼 일치");

        return prefix.append(" ")
                .append(lottoPrizeByPrize.getPrizeMoneyMessage())
                .append(" - ")
                .append(count)
                .append("개")
                .toString();
    }
}
