package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Match;

import java.util.List;

public class WinLottoService {
    private final Lotto winLotto;
    private final int bonusNum;

    public WinLottoService(Lotto winLotto, int bonusNum) {
        this.winLotto = winLotto;
        this.bonusNum = bonusNum;
    }

    public boolean matchBonusNumCheck(Lotto lotto) {
        return lotto.isContainNum(bonusNum);
    }

    public int matchWinLottoCheck(Lotto lotto) {
        List<Integer> winLottoNums = winLotto.getNumbers();
        int matches = 0;

        for (int winLottoNum : winLottoNums) {
            if (lotto.isContainNum(winLottoNum)) {
                matches++;
            }
        }

        return matches;
    }

    public Match convertMatch(int matches, boolean matchBonusNum) {
        if (matches == 5) {
            if (matchBonusNum) {
                return Match.SECOND;
            }
            return Match.THIRD;
        }
        for (Match match : Match.values()) {
            if (match.getNumOfMatches() == matches) {
                return match;
            }
        }
        
        return null;
    }
}
