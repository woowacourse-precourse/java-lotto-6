package lotto.util.parser;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;

public class LottoParser extends Parser {
    /**
     * Description: Parse Lotto to Prize
     */
    public static Prize parseLottoToPrize(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(lotto);
        boolean matchBonusNumber = winningLotto.isMatchBonusNumber(lotto);
        return Prize.of(matchCount, matchBonusNumber);
    }
}
