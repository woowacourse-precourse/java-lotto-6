package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinnerLotto {
    private Lotto winnerLotto;
    private int bonusNumber;

    private WinnerLotto(final Lotto winnerLotto, final int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicationBonusNumber(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerLotto of(final Lotto winnerLotto, final int bonusNumber) {
        return new WinnerLotto(winnerLotto, bonusNumber);
    }

    private void validateNumberRange(int bonusNumber) {
        if(!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateDuplicationBonusNumber(Lotto lotto, int bonusNumber) {
        if(lotto.getLotto()
                .stream()
                .anyMatch(lottoNumber -> lottoNumber == bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호가 있습니다.");
        }
    }

    public LottoRank matchWinnerLotto(Lotto lotto) {
        int matchLottoCount = this.winnerLotto.matchingLottoNumber(lotto);
        boolean matchBonusResult = lotto.matchingBonusNumber(this.bonusNumber);
        return LottoRank.valueOf(matchLottoCount, matchBonusResult);
    }
}
