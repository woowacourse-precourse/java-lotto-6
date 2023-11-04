package lotto;

import lotto.domain.BonusNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Object obj) {
        return numbers.contains(obj);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 로또 숫자를 입력하세요.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> kindOfNumber = new HashSet<>(numbers);
        if (kindOfNumber.size() == numbers.size()) return;
        throw new IllegalArgumentException("중복되지 않은 로또 숫자를 입력해주세요.");
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(number -> number.toString())
                .collect(Collectors.joining(", "));
    }
}
