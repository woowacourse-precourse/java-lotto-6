package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private Integer bonusNumber;
    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        if (super.isContain(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}