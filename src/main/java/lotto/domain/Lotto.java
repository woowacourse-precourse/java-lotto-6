package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLottoSize(numbers);
        Validator.validateNumbersRange(numbers);
        Validator.validateDuplicateLottoNumbers(numbers);
    }

    // TODO: 추가 기능 구현

    public boolean isContainsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        String number = String.join(", ", numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));

        return String.format("[%s]", number);
    }
}
