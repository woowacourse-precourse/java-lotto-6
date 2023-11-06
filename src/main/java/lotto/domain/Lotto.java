package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Integer getMatchLottoNumber(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
