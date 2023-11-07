package lotto;

import java.util.List;
import lotto.config.LottoGameRule;
import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;
import lotto.exception.LottoNumberOutOfRangeException;
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
        int matchedNumberCount = 0;
        for (Integer number : numbers) {
            matchedNumberCount += getMatchedNumberCount(lotto, number);
        }

        return matchedNumberCount;
    }

    private int getMatchedNumberCount(final Lotto lotto, final Integer number) {
        if (lotto.contain(number)) {
            return 1;
        }
        return 0;
    }

    private boolean contain(int number) {
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
