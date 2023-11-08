package lotto.domain.winningManager;

import lotto.constants.LottoConstants;
import lotto.constants.LottoDrawConstants;

import java.util.HashMap;

public class RateOfReturn {

    public double calculateRateOfReturn(HashMap<Integer, Integer> ranks, Integer lottoCount){
        //rank size <= count
        Integer rank5Count = ranks.get(5);
        Integer rank4Count = ranks.get(4);
        Integer rank3Count = ranks.get(3);
        Integer rank2Count = ranks.get(2);
        Integer rank1Count = ranks.get(1);
        double totalReturn = rank1Count * LottoDrawConstants.FIRST_PRIZE_AMOUNT.getValue()
                + rank2Count * LottoDrawConstants.SECOND_PRIZE_AMOUNT.getValue()
                + rank3Count * LottoDrawConstants.THIRD_PRIZE_AMOUNT.getValue()
                + rank4Count * LottoDrawConstants.FOURTH_PRIZE_AMOUNT.getValue()
                + rank5Count * LottoDrawConstants.FIFTH_PRIZE_AMOUNT.getValue();

        return totalReturn / (lottoCount * LottoConstants.LOTTO_PRICE.getValue()) * 100;
    }
}
