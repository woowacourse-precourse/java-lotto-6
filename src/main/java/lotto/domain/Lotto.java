package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.*;

import static lotto.constants.ErrorMessage.DUPLICATE_LOTTO_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicateCheck(numbers);
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Object> duplicateCheck = new HashSet<>();
        for (Integer number : numbers) {
            if (!duplicateCheck.add(number)) {
                throw new InvalidLottoNumberException(DUPLICATE_LOTTO_NUMBER.toString());
            }
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        StringJoiner format = new StringJoiner(", ", "[", "]");
        numbers.forEach(number -> format.add(String.valueOf(number)));

        return format.toString();
    }
}
