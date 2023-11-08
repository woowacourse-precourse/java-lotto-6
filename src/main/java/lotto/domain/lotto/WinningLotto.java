package lotto.domain.lotto;

import lotto.domain.prize.Prize;
import lotto.exception.NotLottoNumberException;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!(Lotto.MIN_NUM <= bonusNumber && bonusNumber <= Lotto.MAX_NUM)) {
            throw new NotLottoNumberException();
        }
    }

    public Prize match(Lotto other) {
        int matchCount = winningLotto.match(other);
        boolean hasBonus = other.hasBonus(bonusNumber);
        return Prize.of(matchCount, hasBonus);
    }
}
