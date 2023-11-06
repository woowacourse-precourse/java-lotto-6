package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.global.ResponseStatus;

import java.util.List;

public class LottoReferee {

    public LottoResult determineLottoRank(Lotto lotto, WinningLotto winningLotto){
        int matchedNumbersCount = NumberHandler.numberMatches(lotto.getNumbers(), winningLotto.getNumbers()).size();
        return null;
    }

    private boolean bonusMatch(List<Integer> number, int bonusNumber){
        return number.contains(bonusNumber);
    }
}
