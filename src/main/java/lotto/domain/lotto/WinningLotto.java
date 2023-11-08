package lotto.domain.lotto;

import lotto.domain.prize.Prize;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize match(Lotto other) {
        int matchCount = winningLotto.match(other);
        boolean hasBonus = other.hasBonus(bonusNumber);
        return Prize.of(matchCount, hasBonus);
    }
}
