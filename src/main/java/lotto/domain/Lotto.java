package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        final String message = "로또 번호의 개수는 6개여야 합니다.";
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        final String message = "로또 번호에 중복된 숫자가 있으면 안됩니다.";
        final long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(message);
        }
    }

    public Rank match(List<Integer> matchNumbers, int bonusNumber) {
        validateNumbersSize(matchNumbers);
        int matchCount = (int) numbers.stream().filter(matchNumbers::contains).count();
        boolean isBonusNumberMatched = numbers.contains(bonusNumber);
        return Rank.valueOf(matchCount, isBonusNumberMatched);
    }

    public void printNumbers() {
        final String collect = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(collect);
    }
}
