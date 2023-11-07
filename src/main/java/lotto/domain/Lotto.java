package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConsts.REQUIRED_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 총 %d개의 번호가 입력되어야 합니다.", REQUIRED_COUNT));
        }
        if (numbers.stream().distinct().count() != REQUIRED_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
