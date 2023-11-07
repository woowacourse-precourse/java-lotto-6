package lotto.domain;

import lotto.util.CompareNumber;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMoneyPrize {
    private final Map<LottoMoney,Integer> lottoResult;
    private CompareNumber compareNumber = new CompareNumber();

    public LottoMoneyPrize() {
        lottoResult = new EnumMap<LottoMoney, Integer>(LottoMoney.class);
        for(LottoMoney lottoMoney : LottoMoney.values()){
            lottoResult.put(lottoMoney, 0);
        }
    }

    public void printLottoPrize(List<Integer> userWin, List<Integer> randomWin, int bonusNum){
        int winnerNum = compareNumber.compareWinnerNum(userWin, randomWin);
        boolean isBonusNumber = compareNumber.compareBonusNum(bonusNum, randomWin);
        LottoMoney lottoMoney = LottoMoney.getLotto(winnerNum,isBonusNumber);
        updateLottoPrize(lottoMoney);
    }

    private void updateLottoPrize(LottoMoney lottoMoney) {
        lottoResult.put(lottoMoney,lottoResult.get(lottoMoney) + 1);
    }

    public Map<LottoMoney, Integer> getLottoMoneyPrize(){
        return lottoResult;
    }

}
