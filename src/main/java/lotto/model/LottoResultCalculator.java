package lotto.model;

import lotto.constants.LottoConstant;

import java.util.ArrayList;

public class LottoResultCalculator {
    int [] lottoSameSize;
    public LottoResultCalculator() {
        lottoSameSize = new int[LottoConstant.LOTTO_SIZE.getConstant() + 2];
    }

    public int [] getWinningLottoSameSize(ArrayList<Lotto> lottos, ArrayList<Integer> prizeNum, int bonusNum) {
        for(Lotto lotto : lottos) {
            int index = lotto.getComparePrizeNumSameSize(prizeNum, bonusNum);
            lottoSameSize[index]++;
        }
        return lottoSameSize;
    }

    public double getEarningsRate() {
        for(int i=0;i<lottoSameSize.length;i++) {

        }
    }
}
