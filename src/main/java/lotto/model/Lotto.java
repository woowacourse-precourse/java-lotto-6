package lotto.model;

import lotto.system.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 생성되지 않았습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumber(List<Integer> numbers) {
        Validator.validateDuplicateNumber(numbers);
    }

    public List<Integer> ascendingSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public LottoPaper toLottoPaper() {
        return new LottoPaper(ascendingSort(numbers));
    }
}
