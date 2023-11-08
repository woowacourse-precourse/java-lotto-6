package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(int number) {
        return lotto.isContain(number);
    }


    public boolean isContainBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
