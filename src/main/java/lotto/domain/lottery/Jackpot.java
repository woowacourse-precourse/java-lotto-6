package lotto.domain.lottery;

import java.util.List;

public final class Jackpot extends Lotto {
    private final int bonusNumber;

    private Jackpot(
            final List<Integer> numbers,
            final int bonusNumber
    ) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Jackpot of(
            final List<Integer> numbers,
            final int bonusNumber
    ) {
        return new Jackpot(numbers, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
