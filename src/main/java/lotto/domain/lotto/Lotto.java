package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        verifyNumbersSize(numbers);
        verifyNoDuplication(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void verifyNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyNoDuplication(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("중복되는 숫자가 있으면 안 됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

