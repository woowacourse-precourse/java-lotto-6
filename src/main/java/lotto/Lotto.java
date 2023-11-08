package lotto;

import java.util.List;
import lotto.domain.LottoNumber;

public class Lotto {
    private static final int SIZE_SCALE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = getSortedNumbers(numbers);
    }

    private List<Integer> getSortedNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateBound(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != SIZE_SCALE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateBound(final List<Integer> numbers) {
        numbers.forEach(LottoNumber::validateBound);
    }

    private void validateDuplicate(final List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (isNotEqual(distinctCount, numbers.size())) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 수가 존재합니다.");
        }
    }

    private boolean isNotEqual(final long distinctCount, final int lottoNumbersCount) {
        return distinctCount != lottoNumbersCount;
    }

    private boolean contains(final int other) {
        return numbers.stream()
                .anyMatch(number -> number.equals(other));
    }

    public long compare(final Lotto other) {
        return numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(final LottoNumber other) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .anyMatch(lottoNumber -> lottoNumber.equals(other));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
