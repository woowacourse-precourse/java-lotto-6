package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.constant.ConstantNumber;
import lotto.constant.LottoPrize;

public class Result {
    private final static int PERCENT = 100;
    private final Map<LottoPrize, Integer> matchResult = new LinkedHashMap<>();
    private float earningRate;

    public Result() {
        for (LottoPrize lottoPrize : LottoPrize.findAllLottoPrize()) {
            matchResult.put(lottoPrize, ConstantNumber.INITIAL_VALUE);
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
                matchResult.get(LottoPrize.findByMatchedNumber(matched)) + ConstantNumber.ONE_CASE);
    }

    public void addFiveMatchWithBonus() {
        matchResult.replace(LottoPrize.FIVE_MATCH_WITH_BONUS,
                matchResult.get(LottoPrize.FIVE_MATCH_WITH_BONUS) + ConstantNumber.ONE_CASE);
        matchResult.replace(LottoPrize.FIVE_MATCH, matchResult.get(LottoPrize.FIVE_MATCH) - ConstantNumber.ONE_CASE);
    }

    public void calculateEarningRate(long earning, int price) {
        earningRate = (float) ((double) earning / price) * PERCENT;
    }
}
