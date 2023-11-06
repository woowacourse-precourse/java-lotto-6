package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.Message;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUnique(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw LottoException.of(Message.NUMBER_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw LottoException.of(Message.NUMBER_RANGE);
            }
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw LottoException.of(Message.NUMBER_UNIQUE);
        }
    }

    // TODO: 추가 기능 구현
}
