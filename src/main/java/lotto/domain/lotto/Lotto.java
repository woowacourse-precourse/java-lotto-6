package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_LENGTH = 6;
    private static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복되지 않는 숫자여야 합니다.";
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(Number::of)
                .sorted()
                .toList();
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int uniqueCount = new HashSet<Integer>(numbers).size();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(Number::getNumber)
                .toList();
    }

    public int matchNumberCount(Lotto lotto) {
        return lotto.matchNumberCount(this.numbers);
    }

    private int matchNumberCount(List<Number> numbers) {
        return numbers.stream()
                .filter(this.numbers::contains)
                .toList()
                .size();
    }

    public boolean contain(Number number) {
        return numbers.contains(number);
    }
}
