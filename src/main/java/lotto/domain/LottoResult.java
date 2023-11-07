package lotto.domain;

import lotto.config.LottoPrize;
import lotto.util.Util;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;


public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private final Map<LottoPrize, Integer> lottoResult;
    private long totalPrizeMoney;

    LottoResult() {
        lottoResult = new EnumMap<>(LottoPrize.class);
        setLottoResult();
    }

    private void setLottoResult() {
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> lottoResult.put(lottoPrize, INITIAL_COUNT));
    }

    public void setResult(LottoPrize lottoPrize) {
        lottoResult.put(lottoPrize, lottoResult.getOrDefault(lottoPrize, INITIAL_COUNT) + 1);
    }

    private long getPrizeMoney(LottoPrize lottoPrize) {
        return LottoPrize.valueOf(lottoPrize.name()).getPrizeMoney();
    }

    private void calculateTotalPrizeMoney() {
        lottoResult.forEach(
                (lottoPrize, count) -> totalPrizeMoney += getPrizeMoney(lottoPrize) * count
        );
    }

    public double calculateProfit(int money) {
        calculateTotalPrizeMoney();
        return Util.round((double) totalPrizeMoney / money);
    }

    public Map<LottoPrize, Integer> getLottoResult() {
        return lottoResult;
    }
}