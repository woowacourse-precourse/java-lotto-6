package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.utils.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.utils.Constants.MINIMUM_LOTTO_NUMBER;

public class BonusNumber {
    private static final String OUT_OF_RANGE_NUMBER_EXCEPTION_FORMAT = "보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.";

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(
                    String.format(OUT_OF_RANGE_NUMBER_EXCEPTION_FORMAT, MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER;
    }

    public boolean isIncludedIn(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
