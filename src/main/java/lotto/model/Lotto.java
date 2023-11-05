package lotto.model;

import static java.util.Arrays.stream;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateOverSize(numbers);
        validateDuplicateNumber(numbers);
        validateInRange(numbers);
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 로또 번호의 개수가 6개가 넘어갔습니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long distinctListSize = numbers.stream()
                .distinct()
                .count();
        if (distinctListSize != numbers.size()) {
            throw new IllegalArgumentException("[Error] 로또 번호가 중복 됐습니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[Error] 범위 밖의 로또 번호가 포함되었습니다.");
            }
        });
    }
}
