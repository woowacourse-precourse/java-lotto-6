package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sort(List<Integer> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchLottoNumber(WinningLotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isContain)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
