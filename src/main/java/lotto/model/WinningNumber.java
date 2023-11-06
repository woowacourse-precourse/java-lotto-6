package lotto.model;

import java.util.List;

public class WinningNumber {

    private final Lotto winningLotto;

    private final BonusNumber bonusNumber;

    public WinningNumber(final List<Integer> numbers, final int bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningLotto = new Lotto(numbers);
        this.bonusNumber = BonusNumber.of(bonusNumber);
    }

    private void validate(final List<Integer> numbers, final int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
