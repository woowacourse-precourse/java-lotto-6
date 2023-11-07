package lotto.domain;

import lotto.domain.Lotto;
import lotto.util.BusinessVaildator;

import java.util.List;

public class WinningLotto extends Lotto {
    private List<Integer> numbers;
    private final int bonusNumber;
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        BusinessVaildator.validateNumberRule(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public List<Integer> getWinningLotto() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
