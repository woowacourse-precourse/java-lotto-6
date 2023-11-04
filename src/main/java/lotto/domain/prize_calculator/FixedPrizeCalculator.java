package lotto.domain.prize_calculator;

import java.util.Arrays;
import java.util.HashMap;
import lotto.domain.lotto_prize.FixedLottoPrize;

public class FixedPrizeCalculator implements PrizeCalculator {
    private HashMap<Long, Integer> matchCountPrizeMap;

    public FixedPrizeCalculator(){
        matchCountPrizeMap=new HashMap<>();

        Arrays.stream(FixedLottoPrize.values())
                .forEach(fixedLottoPrize ->
                        matchCountPrizeMap.put(fixedLottoPrize.getMatchCount(), fixedLottoPrize.getPrize()));
    }

    @Override
    public Integer calculatePrize(Long matchCount) {
        return matchCountPrizeMap.getOrDefault(matchCount, 0);
    }
}
