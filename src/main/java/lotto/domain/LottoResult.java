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
}
