package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumber, int bonusNumber) {
        super(winningLottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(this.getNumbers()::contains)
                .count();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
