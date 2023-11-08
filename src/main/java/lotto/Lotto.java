package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        return numbers.size() != distinctNumbers.size();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        return (int) numbers.stream().filter(other::isContain).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
