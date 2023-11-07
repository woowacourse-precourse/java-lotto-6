package service;

import domain.Amount;
import domain.Lottos;
import domain.Rank;
import domain.WinningNumbers;
import java.util.ArrayList;
import java.util.List;

public class CompareLottoServcie {

    public static Rank rank(Amount amount, Lottos lottos, WinningNumbers winningNumbers) {
        List<Integer> countLottoNumberEqual = winningNumbers.lottoEqualCount(lottos);
        List<Boolean> isBonusNumberEqual = winningNumbers.bonusNumberEqual(lottos);

        List<Integer> lottoRank = new ArrayList<>();
        for (int i = 0; amount.isLargerThen(i); i++) {
            if(isBonusNumberEqual.get(i)){
                lottoRank.add(haveBonusNumberRank(countLottoNumberEqual.get(i)));
                continue;
            }
            lottoRank.add(noHaveBonusNumberRank(countLottoNumberEqual.get(i)));
        }

        return MakeObjectService.rank(lottoRank);
    }

    private static int haveBonusNumberRank(int countEqual){
        if(countEqual < 2){
            return rankCalculator(countEqual);
        }
        return rankCalculator(countEqual) + 1;
    }

    private static int noHaveBonusNumberRank(int countEqual) {
        return rankCalculator(countEqual);
    }

    private static int rankCalculator(int countEqual){
        if(countEqual >= 0 && countEqual <= 2){
            return 6;
        }
        if(countEqual == 3){
            return 5;
        }
        if(countEqual == 4){
            return 4;
        }
        if(countEqual == 5){
            return 3;
        }
        return 1;
    }
}