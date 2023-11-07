package lotto.domain.db;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
