package lotto.model;

import lotto.constant.response.Exception;

public class WinningLotto{
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage()
                    + Exception.WINNING_NUMBERS_DUPLICATE);
        }
    }

    public Rank compare(Lotto targetLotto){
        return Rank.findBy(lotto.matchCount(targetLotto),
                targetLotto.hasNumber(bonusNumber));
    }

}
