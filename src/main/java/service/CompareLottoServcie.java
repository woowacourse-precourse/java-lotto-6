package service;

import static util.EqualNumberAccordRank.FIFTH_EQUAL_NUMBER;
import static util.EqualNumberAccordRank.FIRST_EQUAL_NUMBER;
import static util.EqualNumberAccordRank.FORTH_EQUAL_NUMBER;
import static util.EqualNumberAccordRank.THIRD_EQUAL_NUMBER;
import static util.LottoRankNumber.FIFTH;
import static util.LottoRankNumber.FIRST;
import static util.LottoRankNumber.FOURTH;
import static util.LottoRankNumber.OTHER;
import static util.LottoRankNumber.THIRD;

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
        if(countEqual < FIFTH_EQUAL_NUMBER.get() - 1){
            return rankCalculator(countEqual);
        }
        return rankCalculator(countEqual) + 1;
    }

    private static int noHaveBonusNumberRank(int countEqual) {
        return rankCalculator(countEqual);
    }

    private static int rankCalculator(int countEqual){
        if(countEqual == FIFTH_EQUAL_NUMBER.get()){
            return FIFTH.get();
        }
        if(countEqual == FORTH_EQUAL_NUMBER.get()){
            return FOURTH.get();
        }
        if(countEqual == THIRD_EQUAL_NUMBER.get()){
            return THIRD.get();
        }
        if(countEqual == FIRST_EQUAL_NUMBER.get()){
            return FIRST.get();
        }
        return OTHER.get();
    }
}