package lotto.domain;

import static lotto.utils.validator.Validator.validBlank;
import static lotto.utils.validator.Validator.validLength;
import static lotto.utils.validator.Validator.validRange;
import static lotto.utils.validator.Validator.validUniqueValue;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validBlank(numbers);
        validLength(numbers);
        validRange(numbers);
        validUniqueValue(numbers);
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
