package lotto.core.domain;

import lotto.common.exception.ErrorType;
import lotto.common.exception.LottoGameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw LottoGameException.withType(ErrorType.DUPLICATE_NUMBERS);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isMatchingLottoNumber(int number) {
        return numbers.contains(number);
    }
}
