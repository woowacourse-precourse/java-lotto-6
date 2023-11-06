package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .peek(this::validateNumber)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(int number) {
        if (!containsLottoNumberRange(number)) {
            throw new IllegalArgumentException(String.format("유효한 로또 번호가 아닙니다 : %d", number));
        }
    }

    private boolean containsLottoNumberRange(int number) {
        return IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .toList()
                .contains(number);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateNumbers = findDuplicates(numbers);
        if (!duplicateNumbers.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s 에 중복값이 있습니다: %s", numbers, duplicateNumbers));
        }
    }

    private Set<Integer> findDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> Collections.frequency(numbers, number) > 1)
                .collect(Collectors.toSet());
    }

    public boolean has(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
