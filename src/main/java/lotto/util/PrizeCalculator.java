package lotto.util;

import lotto.domain.lotto.LottoPrize;
import lotto.domain.lotto.LottoRank;
import lotto.domain.prize.PrizeConstant;

import java.util.EnumMap;

public class PrizeCalculator implements PrizeConstant {


    public static int calculatePrizeWithResultBoard(EnumMap<LottoRank, Integer> resultBoard){
        int prize = calculatePrizeWithEachRank(resultBoard);
        return prize;
    }
    private static int calculatePrizeWithEachRank(EnumMap<LottoRank, Integer> resultBoard){
        int prize = 0;
        for (LottoRank lottoRank : resultBoard.keySet()){
            prize += resultBoard.get(lottoRank) * LottoPrize.determinePrizeAmountByRank(lottoRank);
        }
        return prize;
    }
}
