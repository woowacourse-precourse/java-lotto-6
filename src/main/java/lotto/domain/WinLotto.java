package lotto.domain;

import java.util.List;
import lotto.util.ValidationUtil;

public class WinLotto extends Lotto {
    int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        ValidationUtil.isValidBonusNumber(numbers, bonusNumber);
    }
}
