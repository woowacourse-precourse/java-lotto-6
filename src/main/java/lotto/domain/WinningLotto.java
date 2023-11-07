package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private BonusNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, BonusNumber bonusNumber){
        super(numbers);
        bonusNumber.validateDuplicateNumbers(numbers);
    }
}
