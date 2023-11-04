package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto {

    final Integer bonus;

    public WinLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        validateNumber(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateNumber(List<Integer> numbers, Integer bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

}
