package lotto;

import java.util.List;
import lotto.domain.LottoNumber;

public class Lotto {
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateRange(final List<Integer> numbers) {
        boolean notMatchRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (notMatchRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
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
