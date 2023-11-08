package lotto.game;

import lotto.Lotto;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto WinningLotto, int bonusNumber) {
        this.winningLotto = WinningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < Lotto.LOTTO_NUMBER_SIZE; i++) {
            if (lotto.isContain(winningLotto.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonus(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }
}
