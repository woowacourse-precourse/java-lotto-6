package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.Rank;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    /*
     * 1등 : 6개 0
     * 2등 : 5개 1
     * 3등 : 5개 0
     * 4등 : 4개 0
     * 5등 : 3개 0
     * */
    public Rank match(Lotto lotto) {
        int count = 0;
        for(LottoNumber lottoNumber : winningLotto.getLottoNumbers()) {
            if(lotto.contains(lottoNumber)) {
                count++;
            }
        }

        if(count == 6) {
            return Rank.FIRST;
        }
        if(count == 5) {
            if(lotto.contains(bonusNumber)) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        if(count == 4) {
            return Rank.FOURTH;
        }
        if(count == 3) {
            return Rank.FIFTH;
        }

        return null;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBERS_INCLUDE_BONUS_MESSAGE.getMessage());
        }
    }
}
