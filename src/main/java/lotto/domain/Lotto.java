package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.error.LottoErrorMessage;

public class Lotto {
    public static final Integer SIZE = 6;
    public static final Integer PRICE = 1000;
    public static final Integer FIRST_NUMBER = 1;
    public static final Integer LAST_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(LottoErrorMessage.CNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> noDuplication = new HashSet<>(numbers);
        if (noDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(Lotto.FIRST_NUMBER <= number && number <= Lotto.LAST_NUMBER)) {
                throw new IllegalArgumentException(LottoErrorMessage.RANGE);
            }
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
