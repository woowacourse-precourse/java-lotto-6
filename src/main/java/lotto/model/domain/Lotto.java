package lotto.model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.configuration.ErrorMessage;
import lotto.configuration.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isUnique(numbers);
        isNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LOTTO_NUMBER_LENGTH);
        }
    }

    // TODO: 추가 기능 구현
    private void isUnique(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED);
        }
    }

    private void isNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConstants.MIN_LOTTO_NUM || number > LottoConstants.MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }
}
