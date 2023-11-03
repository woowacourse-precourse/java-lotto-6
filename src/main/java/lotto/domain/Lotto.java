package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int SIX = 6;
    private static final String ERROR = "[ERROR] ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIX) {
            throw new IllegalArgumentException(ERROR + "6개의 숫자로 이루어져야 합니다.");
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ERROR + "중복된 숫자가 존재할 수 없습니다.");
        }
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctedNumbers = numbers.stream()
                .distinct()
                .toList();

        return !distinctedNumbers.equals(numbers);
    }
    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
