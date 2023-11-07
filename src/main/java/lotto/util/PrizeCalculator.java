package lotto.util;

import lotto.domain.LottoRank;
import lotto.domain.constant.PrizeConstant;

import java.util.EnumMap;
import java.util.Map;

public class PrizeCalculator implements PrizeConstant {
    private static final Map<LottoRank, Integer> prizeMap = new EnumMap<>(LottoRank.class);
    static {
        prizeMap.put(LottoRank.FIRST, PrizeConstant.FIRST_PRIZE);
        prizeMap.put(LottoRank.SECOND, PrizeConstant.SECOND_PRIZE);
        prizeMap.put(LottoRank.THIRD, PrizeConstant.THIRD_PRIZE);
        prizeMap.put(LottoRank.FOURTH, PrizeConstant.FOURTH_PRIZE);
        prizeMap.put(LottoRank.FIFTH, PrizeConstant.FIFTH_PRIZE);
        prizeMap.put(LottoRank.NONE, PrizeConstant.NONE_PRIZE);
    }
    public static int calculatePrizeWithResultBoard(EnumMap<LottoRank, Integer> resultBoard){
        int prize = calculatePrizeWithEachRank(resultBoard);
        return prize;
    }
    private static int calculatePrizeWithEachRank(EnumMap<LottoRank, Integer> resultBoard){
        int prize = 0;
        for (LottoRank lottoRank : resultBoard.keySet()){
            prize += resultBoard.get(lottoRank) * prizeMap.get(lottoRank);
        }
        return prize;
    }
}
