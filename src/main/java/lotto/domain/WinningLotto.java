package lotto.domain;

import lotto.view.constant.Exception;

import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void validateBonus(int bonus) {
        if (this.contains(bonus)) {
            throw new IllegalArgumentException(Exception.BONUS_DUPLICATED);
        }
    }
}
