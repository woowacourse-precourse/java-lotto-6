package lotto.utils;

import lotto.domain.Lotto;
import lotto.global.constant.LottoRankAndPrize;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoReferee {

    private static final int SECOND_OR_THIRD_RANK = 5;

    public LottoRankAndPrize determineLottoRank(Lotto lotto, WinningLotto winningLotto){
        int matchedNumbersCount = NumberHandler.numberMatches(lotto.getNumbers(), winningLotto.getNumbers()).size();
        if(matchedNumbersCount == SECOND_OR_THIRD_RANK){

        }
        return null;
    }

    private boolean bonusMatch(List<Integer> number, int bonusNumber){
        return number.contains(bonusNumber);
    }
}
