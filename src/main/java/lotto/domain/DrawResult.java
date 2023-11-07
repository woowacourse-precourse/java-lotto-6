package lotto.domain;

import java.util.List;

public class DrawResult {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public DrawResult(List<Integer> numbers, Integer bonusNumber) {
        lotto = new Lotto(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
