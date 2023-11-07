package lotto.domain;

import static lotto.utils.validator.Validator.validateEmpty;
import static lotto.utils.validator.Validator.validateLength;
import static lotto.utils.validator.Validator.validateNumberRange;
import static lotto.utils.validator.Validator.validateUniqueValue;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateEmpty(numbers);
        validateLength(numbers);
        validateNumberRange(numbers);
        validateUniqueValue(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(List<Integer> winningNumber) {
        return (int) numbers.stream().filter(winningNumber::contains).count();
    }

    public boolean isBonusMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
