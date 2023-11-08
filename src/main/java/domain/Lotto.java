package domain;

import enums.ExceptionMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> unDuplicatedNumbers = new HashSet<>(numbers);
        if (unDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                ExceptionMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumber() {
        return numbers;
    }
}
