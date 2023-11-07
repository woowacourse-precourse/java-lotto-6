package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.constant.LottoPrize;

public class Result {
    private static final int INITIAL_VALUE = 0;
    private final Map<LottoPrize, Integer> matchResult = new LinkedHashMap<>();
    private float earningRate;

    public Result() {
        for (LottoPrize lottoPrize : LottoPrize.findAllLottoPrize()) {
            matchResult.put(lottoPrize, INITIAL_VALUE);
        }
    }

    public Map<LottoPrize, Integer> getMatchResult() {
        return matchResult;
    }

    public float getEarningRate() {
        return earningRate;
    }

    public void addWinInformation(int matched) {
        matchResult.replace(LottoPrize.findByMatchedNumber(matched),
                matchResult.get(LottoPrize.findByMatchedNumber(matched)) + 1);
    }

    public void addFiveMatchWithBonus() {
        matchResult.replace(LottoPrize.FIVE_MATCH_WITH_BONUS,
                matchResult.get(LottoPrize.FIVE_MATCH_WITH_BONUS) + 1);
        matchResult.replace(LottoPrize.FIVE_MATCH, matchResult.get(LottoPrize.FIVE_MATCH) - 1);
    }

    public void calculateEarningRate(int earning, int price) {
        earningRate = (float) (earning * 100) / price;
    }
}
