package lotto.domain.lotto;

import static lotto.util.ConstantUtils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ValidationUtils;

public class Lotto {

    protected final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        ValidationUtils.validateNotNull(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public boolean isBonusMatched(BonusNumber bonusNumber) {
        return bonusNumber.isIn(numbers);
    }

    protected void validate(List<Integer> numbers) {
        ValidationUtils.validateNumbersSize(numbers);
        ValidationUtils.validateNoDuplicatedNumberInList(numbers);
        ValidationUtils.validateNumbersInRange(numbers, LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto other = (Lotto) obj;
        return numbers.equals(other.numbers);
    }
}
