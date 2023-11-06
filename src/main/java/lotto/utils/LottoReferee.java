package lotto.utils;

import lotto.domain.Lotto;
import static lotto.global.constant.LottoConstant.*;
import lotto.domain.WinningLotto;
import lotto.global.constant.LottoRankAndPrize;

import java.util.List;

public class LottoReferee {

    private static final int SECOND_OR_THIRD_RANK = 5;

    public LottoRankAndPrize determineLottoRank (Lotto lotto, WinningLotto winningLotto){
        int matchedNumbersCount = NumberHandler.numberMatches(lotto.getNumbers(), winningLotto.getNumbers()).size();
        if(matchedNumbersCount == SECOND_OR_THIRD_RANK){
            if(bonusMatch(lotto.getNumbers(), winningLotto.getBonusNumber())){
                return ;
            }
        }
        return ;
    }

    private boolean bonusMatch(List<Integer> number, int bonusNumber){
        return number.contains(bonusNumber);
    }
}
