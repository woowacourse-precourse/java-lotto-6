package lotto.domain.winningManager;

import lotto.constants.LottoConstants;

import java.util.HashMap;

public class RateOfReturn {

    public double calculateRateOfReturn(HashMap<Integer, Integer> ranks, Integer lottoCount){
        //rank size <= count
        Integer rank5Count = ranks.get(5);
        Integer rank4Count = ranks.get(4);
        Integer rank3Count = ranks.get(3);
        Integer rank2Count = ranks.get(2);
        Integer rank1Count = ranks.get(1);
        double totalReturn = rank1Count * 2000000000
                + rank2Count * 30000000
                + rank3Count * 1500000
                + rank4Count * 50000
                + rank5Count * 5000;

        return totalReturn / (lottoCount * LottoConstants.LOTTO_PRICE.getValue()) * 100;
    }
}
