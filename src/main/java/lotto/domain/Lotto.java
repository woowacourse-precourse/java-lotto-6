package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConsts.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 총 %d개의 번호가 입력되어야 합니다.", REQUIRED_COUNT));
        }
        if (numbers.stream().distinct().count() != REQUIRED_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
        if (!numbers.stream().allMatch(number -> MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d까지의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                        .filter(winningNumbers::contains)
                        .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
