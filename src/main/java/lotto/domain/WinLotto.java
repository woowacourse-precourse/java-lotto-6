package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto {

    private static final Integer MINIMUM_LOTTO_RANGE = 1;
    private static final Integer MAXIMUM_LOTTO_RANGE = 45;

    final Integer bonus;

    public WinLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        validateNumber(numbers, bonus);
        validateBonusRange(bonus);
        this.bonus = bonus;
    }

    private void validateNumber(List<Integer> numbers, Integer bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 보너스 번호와 중복되어서는 안됩니다.");
        }
    }

    private void validateBonusRange(Integer bonus) {
        if (!isInNumberRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45까지 입력 가능합니다.");
        }
    }

    private boolean isInNumberRange(Integer number) {
        return (number >= MINIMUM_LOTTO_RANGE && number <= MAXIMUM_LOTTO_RANGE);
    }

}
