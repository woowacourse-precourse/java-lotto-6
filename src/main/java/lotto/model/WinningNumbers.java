package lotto.model;

import java.util.List;

import lotto.model.result.LottoMatchResult;

public class WinningNumbers extends Lotto {

    private final int bonusNumber;

    private WinningNumbers(final List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validateInRange(bonusNumber);
        validateNotDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(final List<Integer> numbers, final int bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

    private void validateInRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotDuplicated(final int bonusNumber) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public LottoMatchResult match(final Lotto lotto) {
        int matchCount = (int) lotto.stream().filter(this::contains).count();
        boolean hasBonus = lotto.stream().anyMatch(number -> number == bonusNumber);
        return new LottoMatchResult(matchCount, hasBonus);
    }
}
