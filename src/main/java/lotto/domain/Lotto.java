package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicatedLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }
}
