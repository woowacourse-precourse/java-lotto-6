package lotto.domain.prize_calculator;

import java.util.Arrays;
import java.util.HashMap;
import lotto.domain.lotto_prize.FixedLottoPrizeStandard;

public class FixedPrizeCalculator implements PrizeCalculator {
    private HashMap<Long, Integer> matchCountPrizeMap;

    public FixedPrizeCalculator(){
        matchCountPrizeMap=new HashMap<>();

        Arrays.stream(FixedLottoPrizeStandard.values())
                .forEach(fixedLottoPrizeStandard ->
                        matchCountPrizeMap.put(fixedLottoPrizeStandard.getMatchCount(), fixedLottoPrizeStandard.getPrize()));
    }

    @Override
    public Integer calculatePrize(Long matchCount) {
        return matchCountPrizeMap.getOrDefault(matchCount, 0);
    }
}
