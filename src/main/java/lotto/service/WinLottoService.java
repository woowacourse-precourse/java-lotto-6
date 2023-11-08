package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Match;

import java.util.List;

public class WinLottoService {
    private final Lotto winLotto;
    private final int bonusNum;

    public WinLottoService(Lotto winLotto, int bonusNum) {
        validate(winLotto, bonusNum);
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

    void validate(Lotto winLotto, int bonusNum) {
        if (winLotto.isContainNum(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복되지 않게 입력해주세요.");
        }
    }
}
