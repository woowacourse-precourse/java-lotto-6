package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.global.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalStateException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
