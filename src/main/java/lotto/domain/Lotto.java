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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자만 가능합니다.");
        }

        validateUnique(numbers);
    }

    private void validateUnique(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if(uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("서로 다른 번호만 입력 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean includes(int bonus) {
        return this.numbers.contains(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        if(numbers != null) {
            return numbers.equals(lotto.numbers);
        }
        return lotto.numbers == null;
    }

    @Override
    public int hashCode() {
        if(numbers != null) {
            numbers.hashCode();
        }

        return 0;
    }
}
