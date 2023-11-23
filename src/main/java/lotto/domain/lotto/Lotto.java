package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctSize != numbers.size()) {
            //todo
            throw new IllegalArgumentException();
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
