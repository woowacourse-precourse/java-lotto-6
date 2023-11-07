package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.global.constant.LottoRankAndPrize;

import java.util.List;

public class LottoReferee {

    public LottoReferee(){
    }

    public LottoRankAndPrize determineLottoRank (Lotto lotto, WinningLotto winningLotto){
        int matchedNumbersCount = NumberHandler.numberMatches(lotto.getNumbers(), winningLotto.getNumbers()).size();
        boolean bonusMatch = isBonusMatch(lotto.getNumbers(), winningLotto.getBonusNumber());
        return LottoRankAndPrize.determineRankByLottoMatched(matchedNumbersCount, bonusMatch);
    }

    private boolean isBonusMatch(List<Integer> number, int bonusNumber){
        return number.contains(bonusNumber);
    }
}
