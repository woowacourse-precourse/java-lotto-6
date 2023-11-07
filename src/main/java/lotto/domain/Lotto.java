package lotto.domain;

import java.util.List;
import lotto.utils.Validator;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
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

    private boolean contain(final int number) {
        return numbers.contains(number);
    }

    public boolean hasBonusNumber(final LottoNumber bonusNumber) {
        return bonusNumber.isMatched(numbers);
    }


    public int size() {
        return numbers.size();
    }

    @Override
    public List<Integer> numbers() {
        return numbers.stream()
                .toList();
    }
}
