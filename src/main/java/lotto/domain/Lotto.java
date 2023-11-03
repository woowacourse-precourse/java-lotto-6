package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        LottoValidator.validateNotDuplicate(numbers);
        validateInRangeEachNumber(numbers);
    }

    // TODO: 테스트 코드 추가
    public String getLottoNumber() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchNumbers(Lotto other) {
        return (int) this.numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validateInRangeEachNumber(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateInRange);
    }
}
