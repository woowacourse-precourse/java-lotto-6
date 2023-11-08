package lotto.model;

import lotto.constants.LottoConstant;

import java.util.ArrayList;

public class LottoResultCalculator {
    int [] lottoSameSize;
    int [] lottoPrizeMoney;
    public LottoResultCalculator() {
        lottoSameSize = new int[LottoConstant.LOTTO_SIZE.getConstant() + 2];
        lottoPrizeMoney = new int[LottoConstant.LOTTO_SIZE.getConstant() + 2];
        lottoPrizeMoney[3] = LottoConstant.STATICS_FIFTH_PRIZE.getConstant();
        lottoPrizeMoney[4] = LottoConstant.STATICS_SECOND_PRIZE.getConstant();
        lottoPrizeMoney[5] = LottoConstant.STATICS_THIRD_PRIZE.getConstant();
        lottoPrizeMoney[6] = LottoConstant.STATICS_FOURTH_PRIZE.getConstant();
        lottoPrizeMoney[7] = LottoConstant.STATICS_FIFTH_PRIZE.getConstant();
    }

    public int [] getWinningLottoSameSize(ArrayList<Lotto> lottos, ArrayList<Integer> prizeNum, int bonusNum) {
        for(Lotto lotto : lottos) {
            int index = lotto.getComparePrizeNumSameSize(prizeNum, bonusNum);
            lottoSameSize[index]++;
        }
        return lottoSameSize;
    }

    public double getEarningsRate(int buyPrice) {
        long prizeSum = 0;

        for(int i=3;i<lottoSameSize.length;i++) {
            prizeSum += lottoPrizeMoney[i] * lottoSameSize[i];
        }

        return prizeSum / (double)buyPrice * 100.0;
    }
}
