package lotto;

import java.util.List;
import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(LottoNumbers lottoNumbers) {
        List<Integer> numbers = lottoNumbers.convertToIntegerList();
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidSizeException();
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new DuplicateNumberException();
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        int matchedNumberCount = 0;
        for (Integer number : numbers) {
            matchedNumberCount += getMatchedNumberCount(lotto, number);
        }

        return matchedNumberCount;
    }

    private int getMatchedNumberCount(Lotto lotto, Integer number) {
        if (lotto.contain(number)) {
            return 1;
        }
        return 0;
    }

    private boolean contain(int number) {
        return numbers.contains(number);
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return bonusNumber.isMatched(numbers);
    }
}
