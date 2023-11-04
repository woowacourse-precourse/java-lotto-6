package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import lotto.config.AppConfig;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate(distinct(numbers));
        validate(validRange(numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != AppConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Stream<Integer> stream() {
        return numbers.stream();
    }

    private List<Integer> distinct(List<Integer> numbers) {
        return numbers.stream().distinct().toList();
    }

    private List<Integer> validRange(List<Integer> numbers) {
        return numbers.stream().filter(integer -> integer <= AppConfig.LOTTO_NUMBER_MAX_RANGE)
                .filter(integer -> integer >= AppConfig.LOTTO_NUMBER_MIN_RANGE)
                .toList();
    }

}
