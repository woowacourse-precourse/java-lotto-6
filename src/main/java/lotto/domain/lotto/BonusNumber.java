package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public boolean isIn(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BonusNumber other = (BonusNumber) obj;
        return bonusNumber == other.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
