package lotto.model;

import java.util.List;

public class LottoWinningNumbers extends Lotto {

    public static final String INVALID_BONUS_NUMBER = "보너스 번호는 1부터 45 사이의 숫자이며, 당첨번호와 중복될 수 없습니다.";

    private final int bonusNumber;

    private LottoWinningNumbers(final List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validateInRange(bonusNumber);
        validateNotDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumbers of(final List<Integer> numbers, final int bonusNumber) {
        return new LottoWinningNumbers(numbers, bonusNumber);
    }

    public static LottoWinningNumbers of(final Lotto lotto, final int bonusNumber) {
        return of(lotto.stream().toList(), bonusNumber);
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

    public int getBonusNumber() {
        return bonusNumber;
    }
}
