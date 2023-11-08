package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto {
    int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
