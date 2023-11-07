package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.INVAILD_LOTTO_SIZE;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto { //Lotto = numbers
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNonDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNonDuplicatedNumbers(final List<Integer> numbers) {
        List<Integer> nonDuplicatedNumbers = numbers.stream().distinct().toList();
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVAILD_LOTTO_SIZE.getMessage());
        }
    }

}
