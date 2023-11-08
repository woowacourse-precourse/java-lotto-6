package lotto.domain;

import java.util.List;
import lotto.utils.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        Validator.validateDuplicate(numbers);
        Validator.validateInRange(numbers);
        Validator.validateSize(numbers);
    }

    public int countMatchingNumbers(final Lotto lotto) {
        return numbers.stream()
                .map(number -> getMatchedNumberCount(lotto, number))
                .reduce(0, Integer::sum);
    }

    private int getMatchedNumberCount(final Lotto lotto, final Integer number) {
        if (lotto.contain(number)) {
            return 1;
        }
        return 0;
    }

    private boolean contain(final int number) {
        return numbers.contains(number);
    }

    public boolean hasBonusNumber(final LottoNumber bonusNumber) {
        return bonusNumber.isMatched(numbers);
    }

    public int size() {
        return numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .toList();
    }
}
