package lotto.domain;

import lotto.Rank;

public record WinningNumbers(Lotto winningLotto, int bonus) {
    public Rank rank(Lotto lotto) {
        return lotto.rank(winningLotto, bonus);
    }
}
