package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.global.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumber = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return sortedNumber;
    }
    // TODO: 추가 기능 구현
}
